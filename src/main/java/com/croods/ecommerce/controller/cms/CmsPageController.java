package com.croods.ecommerce.controller.cms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.cms.CmsPageService;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.cms.CmsPageType;
import com.croods.ecommerce.vo.cms.CmsPagesVo;

@RestController
@RequestMapping("/cmsPages")
public class CmsPageController {

    @Autowired
    CmsPageService cmsPageService;
    
    @Autowired
	APITokenService apiTokenService;

    @PostMapping(value = { "/upload" })
    @ResponseBody
    public ApiResponse createCmsPage(@RequestParam("type") String type, @RequestBody CmsPagesVo cmsPagesVo,
    		@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
    	
    	APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
    	
    	
    	if (apiToken == null) {
			System.err.println("HELLO");
			return new ApiResponse(false, "No Token Found", null);
		} else {
			
			if (isValidCmsPageType(type)) {
				return new ApiResponse(true,"",cmsPageService.createCmsPage(type, cmsPagesVo.getCmsPageContent()));
	        }else {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid CMS page type");	        	
	        }
			
		}
    	
        
        //return cmsPageService.createCmsPage(type, content);
    	
    }

    
  //-------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public CmsPagesVo getCmsPageById(@PathVariable Long id) {
        return cmsPageService.getCmsPageById(id);
    }
    
    
  //-------------------------------------------------------------------------------------------------------------------------------  

//    @GetMapping
//    public List<CmsPagesVo> getAllCmsPages() {
//        return cmsPageService.getAllCmsPages();
//    }
    @GetMapping("/byType/{type}")
    public ApiResponse getCmsPagesByType(@PathVariable("type") String cmsPageType, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
        APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);

        if (apiToken == null) {
            return new ApiResponse(false, "No Token Found", null);
        } else {
            long companyId = apiToken.getCompanyId();
            long branchId = apiToken.getBranchId();
            long userId = apiToken.getUserFrontId();
            System.err.println("Company ID: " + companyId + ", Branch ID: " + branchId + ", User ID: " + userId);

            List<CmsPagesVo> cmsPages = cmsPageService.getCmsPagesByCompanyIdAndBranchIdAndUserIdAndCmsPageType(companyId, branchId, userId, cmsPageType);

            if (cmsPages.size() > 0) {
                return new ApiResponse(true, "Success", cmsPages);
            } else {
                return new ApiResponse(false, "No CMS pages found", null);
            }
        }
    }
  


    //-------------------------------------------------------------------------------------------------------------------------------
        @GetMapping
        public ApiResponse getAllCmsPages(@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
            APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);

            if (apiToken == null) {
                return new ApiResponse(false, "No Token Found", null);
            } else {
                long companyId = apiToken.getCompanyId();
                long branchId = apiToken.getBranchId();
                long userId = apiToken.getUserFrontId();
                System.err.println("Company ID: " + companyId + ", Branch ID: " + branchId + ", User ID: " + userId);

                List<CmsPagesVo> cmsPages = cmsPageService.findCmsPagesVos(companyId, branchId, userId);

                if (cmsPages.size() > 0) {
                    return new ApiResponse(true, "Success", cmsPages);
                } else {
                    return new ApiResponse(false, "No CMS pages found", null);
                }
            }
        }
        
        
     //-------------------------------------------------------------------------------------------------------------------------------
        
        
        @DeleteMapping(value = { "/delete/{cmsPageId}" })
        @ResponseBody
        public ApiResponse deleteCmsPage(@PathVariable("cmsPageId") Long pageId) {
            boolean deleted = cmsPageService.deleteCmsPage(pageId);
            if (deleted) {	
                return new ApiResponse(true, "Deleted Cms Page SuccuesFully", null);
            } else {
                //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CMS page not found"); 
            	return new ApiResponse(false, "Cms Page Not Found ", HttpStatus.NOT_FOUND);
            }
        }


        //-------------------------------------------------------------------------------------------------------------------------------
        
        @PutMapping(value = { "/update/{id}" })
        @ResponseBody
        public ApiResponse updateCmsPage(@PathVariable("id") Long id,
        @RequestParam("type") String type,
        @RequestBody CmsPagesVo cmsPagesVo,
        @RequestHeader(value = "API_TOKEN") String API_TOKEN) {

     
        try {
            APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);

            if (apiToken == null) {
                return new ApiResponse(false, "No Token Found", null);
            } else {
                if (isValidCmsPageType(type)) {
                    CmsPagesVo existingPage = cmsPageService.findCmsPageById(id);
                    if (existingPage == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Page not found");
                    }
                    existingPage.setCmsPageType(cmsPagesVo.getCmsPageType());
                    existingPage.setCmsPageContent(cmsPagesVo.getCmsPageContent());
                    CmsPagesVo updatedPage = cmsPageService.updateCmsPage(existingPage);
                    return new ApiResponse(true, "Page updated successfully", updatedPage);
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid CMS page type");
                }
            }
        } catch (Exception e) {
            return new ApiResponse(false, "Failed to update CMS page", null);
        }
        }
        

        
        
        
        
    private boolean isValidCmsPageType(String type) {
        return Arrays.asList(Constant.PRIVACY_POLICY, Constant.CANCELLATION_POLICY,Constant.ABOUT_US,Constant.CONTACT_US,
        		Constant.REFUND_POLICY,Constant.RETURN_POLICY,Constant.TERMS_AND_CONDITION)
                .contains(type);
        
        
        
        
        
    }
}
