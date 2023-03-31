package com.croods.ecommerce.controller.profile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.config.SecurityValidation;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.dto.file.FileValidationResponse;
import com.croods.ecommerce.exception.MyFileNotFoundException;
import com.croods.ecommerce.repo.profile.LogoUploadRepository;
import com.croods.ecommerce.repo.profile.MyProfileRepository;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.azure.AzureBlobService;
import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.profile.LogoUploadVo;
import com.croods.ecommerce.vo.profile.MyProfileVo;





@RestController
@RequestMapping("/api/v1/ecommerce/profiles")
public class MyProfileController {
	
	  @Autowired
	    private MyProfileRepository profileRepository;
	  
	  @Autowired
		APITokenService apiTokenService;
	  
	  @Autowired
	  private LogoUploadRepository logoUploadRepository;
	  
//	  @Autowired
//	    private FileStorageServiceImpl fileStorageServiceImpl;
	  
		@Autowired
		SecurityValidation securityValidation;

		@Autowired
		AzureBlobService azureBlobService;

		@Value("${FILE_UPLOAD_SERVER}")
		private String FILE_UPLOAD_SERVER;

		@Value("${CONTAINER_NAME}")
		private String CONTAINER_NAME;
	  
	  private static final Logger logger = LoggerFactory.getLogger(MyProfileController.class);

	    @GetMapping("")
	    public ApiResponse getAllProfiles() {
	       // return profileRepository.findAll();
	    	return new ApiResponse(true,"List of All Profiles",profileRepository.findAll());
	    }

	    @GetMapping("/{id}")
	    public ApiResponse getProfileById(@PathVariable Long id) {
	        MyProfileVo profile = profileRepository.findById(id).orElse(null);
	        if (profile != null) {
	            return new ApiResponse(true, "List of All Profile by id", profile);
	        } else {
	            return new ApiResponse(false, "Profile not found for id: " + id, null);
	        }
	    }



//	    @PostMapping("/add")
//	    public ApiResponse createProfile(@RequestBody MyProfile profile) {
//	        try {
//	            return new ApiResponse(true, "Profile Added Successfully", profileRepository.save(profile));
//	        } catch (Exception e) {
//	            return new ApiResponse(false, "Failed to add Profile", null);
//	        }
//	    }

	    @PostMapping("/add")
	    public ApiResponse createProfile(@RequestBody MyProfileVo profile) {
	        // Check if any required field is missing
	        if (profile.getName() == null || profile.getEmail() == null || profile.getAddress() == null
	        		|| profile.getProfileImageUrl()== null) {
	            return new ApiResponse(false, "Missing required field(s)", null);
	        }
	        try {
	            return new ApiResponse(true, "Profile added successfully", profileRepository.save(profile));
	        } catch (Exception e) {
	            return new ApiResponse(false, "Failed to add profile", null);
	        }
	    }

	    @PutMapping("/{id}")
	    public ApiResponse updateProfile(@PathVariable Long id, @RequestBody MyProfileVo profile) {
	        try {
	            MyProfileVo existingProfile = profileRepository.findById(id).orElse(null);
	            if (existingProfile == null) {
	                return new ApiResponse(false, "Profile not found", null);
	            }
	            existingProfile.setName(profile.getName());
	            existingProfile.setEmail(profile.getEmail());
	            existingProfile.setAddress(profile.getAddress());
	            existingProfile.setProfileImageUrl(profile.getProfileImageUrl()); // set the new field
	            return new ApiResponse(true, "Profile updated successfully", profileRepository.save(existingProfile));
	        } catch (Exception e) {
	            return new ApiResponse(false, "Failed to update profile", null);
	        }
	    }

//	    @PutMapping("/{id}")
//	    public ApiResponse updateProfile(@PathVariable Long id, @RequestBody MyProfile profile) {
//	        MyProfile existingProfile = profileRepository.findById(id).orElse(null);
//	        if (existingProfile == null) {
//	            //return null;
//	        }
//	        existingProfile.setName(profile.getName());
//	        existingProfile.setEmail(profile.getEmail());
//	        existingProfile.setAddress(profile.getAddress());
//	        existingProfile.setProfileImageUrl(profile.getProfileImageUrl()); // set the new field
//	       // return profileRepository.save(existingProfile);
//	        return new ApiResponse(true,"Profile Update successfully",profileRepository.save(existingProfile));
//	    }

	    @DeleteMapping("/{id}")
	    public ApiResponse deleteProfile(@PathVariable Long id) {
	        try {
	            profileRepository.deleteById(id);
	            return new ApiResponse(true, "Profile Deleted Successfully", null);
	        } catch (Exception e) {
	            return new ApiResponse(false, "Profile not found for id: " + id, e.getMessage());
	        }
	    }

	    
	    
	    //upload Logo methods---------------------------------------------------------------------------------------------------
	    	
//	    @PostMapping("/uploadFile")
//	    public ApiResponse fileUpload(@RequestParam("file") MultipartFile file) {
//	        try {
//				String fileName = fileStorageServiceImpl.storeFile(file);
//
//				String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//				        .path("/api/v1/dForDR/profiles/downloadFile/")
//				        .path(fileName)
//				        .toUriString();
//
//				LogoUploadVo logoUpload = new LogoUploadVo();
//				logoUpload.setFileName(fileName);
//				logoUpload.setFileDownloadUri(fileDownloadUri);
//				logoUpload.setFileType(file.getContentType());
//				logoUpload.setSize(file.getSize());
//
//				logoUpload = logoUploadRepository.save(logoUpload);
////	        return new LogoUploadVo(logoUpload.getId(), logoUpload.getFileName(), logoUpload.getFileDownloadUri(),
////	        		logoUpload.getFileType(), logoUpload.getSize());
//				return new ApiResponse(true,"Profile Saved Succuesfully",logoUpload);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//			
//				return new ApiResponse(false,"Something Problem",e.getClass());
//			} 
//	    }
	    
	    @PostMapping(value = { "/uploadFile" })
		public ApiResponse uploadLogo(@RequestParam("file") MultipartFile file, HttpSession session,
				HttpServletRequest request,@RequestHeader(value = "API_TOKEN") String API_TOKEN,
				@RequestParam(value = "user_id") long user_id) throws IOException {

	    	APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
	    	ApiResponse apiResponse = new ApiResponse(false, "Something Went Wrong", null);
	    	
	    	if (apiToken == null) {
		    	System.err.println("HELLO");
		        return new ApiResponse(false, "No Token Found", null);
		    }else{
	    		Map<String, String> azureResponse = new HashedMap<>();
				// UserFrontVo
				// userFrontVo=userRepository.findByUserFrontId(Long.parseLong(session.getAttribute("userId").toString()));
				System.out.println("in=======================");
				if (file.isEmpty()) {
					System.out.println("file is emplty");
				} else {
					System.err.println("INSIDE THIS OVER");
					FileValidationResponse fileValidationResponse = securityValidation.validateFile(file, Constant.FILE_IMAGE);
					if (fileValidationResponse.isValid()) {
						System.err.println("INSIDE FILE IS VALID");
						try {
							System.err.println("INSIDE TRY BLOCK");
							
							String fileName2, saveDirectory = null;

							File convFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")
									+ file.getOriginalFilename());
							file.transferTo(convFile);

							File fb = convFile;// ImageResize.convert(file);

							String fileName = fb.getName();
							String uploadStatus = "500";
							String azureImageSrc = "";
							if (FILE_UPLOAD_SERVER.equals(Constant.FILE_UPLOAD_SERVER_AZURE)) {
								System.err.println("INSIDE FILE_UPLOAD_SERVER " + FILE_UPLOAD_SERVER);
								azureResponse = azureBlobService.sendLogoToAZURE(fb, fileName);
								System.err.println("HERE azureResponse " + azureResponse);
								if (!azureResponse.isEmpty()) {
									if (StringUtils.isNotBlank(azureResponse.get("status"))
											&& azureResponse.get("status").equals("200")) {
										uploadStatus = "200";
										azureImageSrc = azureResponse.get("imageSrc");
									}
								}
							}
							if (uploadStatus == "200") {
							    System.out.println("DTATATAA---->>>" + fileName);
							    apiResponse = new ApiResponse(true, "Uploded",azureResponse);
							    logoUploadRepository.updateLogoAndLogoSignedSrc(azureImageSrc, azureImageSrc, user_id);
								
							    }
							

//							if (uploadStatus == "200") {
//								System.out.println("DTATATAA---->>>" + fileName);
//								 // Create a new LogoVo object
//						        LogoUploadVo logoVo = new LogoUploadVo();
//						        
//						        // Set the logo information in the LogoVo object
//						        logoVo.setFileName(fileName);
//						        logoVo.setSignedSrc(azureResponse.get("imageSrc"));
//						        logoVo.setImgsrc(azureResponse.get("signedSrc"));
//
//						        // Save the LogoVo object in the database
//						       logoUploadRepository.save(logoVo);
//								apiResponse = new ApiResponse(true, "Uploded",azureResponse.get("imageSrc"));
//							}
						} catch (IOException e) {
							e.printStackTrace();
							// logger.error("File Uploading Error"+e.toString());
							apiResponse = new ApiResponse(false, "Something Went Wrong", null);
							System.out.println(e);
						}
					}else {
						System.err.println("FILE IS NOT VALID");
						apiResponse = new ApiResponse(false, "FILE IS NOT VALID", null);
					}
	    		
	    	

			
			}

			return apiResponse;
		}


	
	    }
	
	    //----------------------------------------------------------------------------------------------------------------------------
	    
	    
//	    @GetMapping("/downloadFile/{fileName:.+}")
//	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//	        // Load file as Resource
//	        Resource resource = fileStorageServiceImpl.loadFileAsResource(fileName);
//
//	        // Try to determine file's content type
//	        String contentType = null;
//	        try {
//	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//	        } catch (IOException ex) {
//	            logger.info("Could not determine file type.");
//	        }
//
//	        // Fallback to the default content type if type could not be determined
//	        if(contentType == null) {
//	            contentType = "application/octet-stream";
//	        }
//
//	        return ResponseEntity.ok()
//	                .contentType(MediaType.parseMediaType(contentType))
//	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//	                .body(resource);
//	    }
	    
	  //----------------------------------------------------------------------------------------------------------------------------
//	    
//	    @PutMapping("/updateFile/{id}")
//		public ApiResponse updateFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
//			try {
//				LogoUploadVo logoUpload = logoUploadRepository.findById(id)
//						.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
//
//				// Update Logo
////	        LogoUploadVo logoUploads = new LogoUploadVo();
//				String newFileName = fileStorageServiceImpl.storeFile(file);
//				logoUpload.setFileName(newFileName);
//				logoUpload.setFileDownloadUri(newFileName);
//				logoUpload.setFileType(file.getContentType());
//				logoUpload.setSize(file.getSize());
//
//				logoUpload = logoUploadRepository.save(logoUpload);
//
//				String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//						.path("/api/v1/ecommerce/profiles/downloadFile/").path(newFileName).toUriString();
//
//				// Return the updated file information
////	        return new LogoUploadVo(logoUpload.getId(), logoUpload.getFileName(), fileDownloadUri,
////	                logoUpload.getFileType(), logoUpload.getSize());
//				return new ApiResponse(true, "Profile Update Succuesfully", logoUpload);
//				
//			} catch (Exception e) 
//			{
//				return new ApiResponse(false,"Something Wrong",e.getMessage());
//			
//			}
//		}

	  //----------------------------------------------------------------------------------------------------------------------------
	    
	    //Delete Logo
	    
	    @DeleteMapping("/logo/{id}")
		public ApiResponse deletelogo(@PathVariable Long id) {
			try {
				logoUploadRepository.deleteById(id);
				return new ApiResponse(true, "Logo deleted successfully", null);
			} catch (Exception e) {
				return new ApiResponse(false, "Failed to delete Logo", e.getMessage());
			}
		}
	    
	    
}
