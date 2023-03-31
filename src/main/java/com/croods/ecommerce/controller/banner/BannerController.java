package com.croods.ecommerce.controller.banner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.config.SecurityValidation;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.dto.file.FileValidationResponse;
import com.croods.ecommerce.repo.banner.BannerRepository;
import com.croods.ecommerce.service.EcommerceAdmin.EcommerceAdminServiceImpl;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.azure.AzureBlobService;
import com.croods.ecommerce.service.banner.BannerService;
import com.croods.ecommerce.service.banner.BannerServiceImpl;
import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.banner.BannerVo;

@Controller
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	SecurityValidation securityValidation;

	@Autowired
	APITokenService apiTokenService;

	@Autowired
	BannerService bannerService;

	@Autowired
	AzureBlobService azureBlobService;

	@Autowired
	BannerRepository bannerRepository;

	@Value("${FILE_UPLOAD_SERVER}")
	private String FILE_UPLOAD_SERVER;

	@Value("${CONTAINER_NAME}")
	private String CONTAINER_NAME;

	// --------------------------------------------------------------------------------------------------------------------------------

	@PostMapping(value = { "/upload" })
	@ResponseBody
	public ApiResponse uploadBanner(@RequestParam("file") MultipartFile file, HttpSession session,
			HttpServletRequest request, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@RequestParam("title") String title, @RequestParam("subtitle") String subtitle) throws IOException {

		APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
		ApiResponse apiResponse = new ApiResponse(false, "Something Went Wrong", null);

		if (apiToken == null) {
			System.err.println("HELLO");
			return new ApiResponse(false, "No Token Found", null);
		} else {

			Map<String, String> azureResponse = new HashedMap<>();
			// UserFrontVo
			// userFrontVo=userRepository.findByUserFrontId(Long.parseLong(session.getAttribute("userId").toString()));
			System.out.println("in=======================");
			if (file.isEmpty()) {
				System.out.println("file is emplty");
			} else {
				System.err.println("INSIDE THIS OVER");
				FileValidationResponse fileValidationResponse = securityValidation.validateFile(file,
						Constant.FILE_IMAGE);
				if (fileValidationResponse.isValid()) {
					System.err.println("INSIDE FILE IS VALID");
					try {
						System.err.println("INSIDE TRY BLOCK");

						String fileName2, saveDirectory = null;

						File convFile = new File(System.getProperty("java.io.tmpdir")
								+ System.getProperty("file.separator") + file.getOriginalFilename());
						file.transferTo(convFile);

						File fb = convFile;// ImageResize.convert(file);

						String fileName = fb.getName();
						String uploadStatus = "500";
						String azureImageSrc = "";
						if (FILE_UPLOAD_SERVER.equals(Constant.FILE_UPLOAD_SERVER_AZURE)) {
							System.err.println("INSIDE FILE_UPLOAD_SERVER " + FILE_UPLOAD_SERVER);
							azureResponse = azureBlobService.sendBannerToAZURE(fb, fileName, 0, 0);
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
							BannerVo banner = new BannerVo();
							banner.setBannerTitle(title);
							banner.setBannerSubTitle(subtitle);
							banner.setSrc(azureImageSrc);
							bannerRepository.save(banner);

							Map<String, String> response = new HashMap<>();
							response.put("status", "success");
							response.put("message", "Banner uploaded successfully");
							response.put("title", banner.getBannerTitle());
							response.put("subtitle", banner.getBannerSubTitle());
							response.put("src", banner.getSrc());
							return apiResponse = new ApiResponse(true, "Uploded", response);

						}
					} catch (IOException e) {
						e.printStackTrace();
						// logger.error("File Uploading Error"+e.toString());
						System.out.println(e);
						apiResponse = new ApiResponse(false, "Something Went Wrong", null);
					}
				} else {
					System.err.println("FILE IS NOT VALID");
					apiResponse = new ApiResponse(false, "FILE IS NOT VALID", null);
				}

			}
			return apiResponse;

		}

	}

	//--------------------------------------------------------------------------------------------------------------------------------

//	@GetMapping(value = "/view/banners")
//	@ResponseBody
//	public ApiResponse getAllBanners(@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
//	    APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
//	    
//	    
//	    
//	    if (apiToken == null) {
//	        return new ApiResponse(false, "No Token Found", null);
//	    }
//	    List<BannerVo> banners = bannerRepository.findAll();
//	    if (banners.isEmpty()) {
//	        return new ApiResponse(false, "No banners found", null);
//	    }
//	    return new ApiResponse(true, "Success", banners);
//	}

	@GetMapping(value = "/view/banners")
	@ResponseBody
	public ApiResponse getAllBanners(@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
	    APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
	    
	    if (apiToken == null) {
	        return new ApiResponse(false, "No Token Found", null);
	    } else {
	    	System.err.println("TOKEN :: " + apiToken.getApiTokenId());
	        long companyId = apiToken.getCompanyId();
	        long branchId = apiToken.getBranchId();
	        long userId = apiToken.getUserFrontId();
	        System.err.println("Company ID: " + companyId + ", Branch ID: " + branchId + ", User ID: " + userId);

	        List<BannerVo> banners = new ArrayList<>();
//	        if (StringUtils.isNotBlank(title) && StringUtils.isNotBlank(subtitle)) {
//	          
//	        	
//	           
//	        } else {
//	            banners = bannerRepository.findAll();
//	        }
	        banners = bannerService.findBannerVos(companyId, branchId, userId);

	        if (banners.size() > 0) {
	            return new ApiResponse(true, "Success",banners);	            
	        } else {
	            return new ApiResponse(false, "No banners found", null);
	        }
	    }
	}


	// --------------------------------------------------------------------------------------------------------------------------------

	@GetMapping(value = "/view/banners/{id}")
	@ResponseBody
	public ApiResponse getBannerById(@PathVariable("id") Long id,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
		if (apiToken == null) {
			return new ApiResponse(false, "No Token Found", null);
		}
		Optional<BannerVo> optionalBanner = bannerRepository.findById(id);
		if (optionalBanner.isEmpty()) {
			return new ApiResponse(false, "Banner not found", null);
		}
		BannerVo banner = optionalBanner.get();
		return new ApiResponse(true, "Success", banner);
	}

}
