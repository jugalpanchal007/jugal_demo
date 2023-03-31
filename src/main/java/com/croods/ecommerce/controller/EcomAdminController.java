package com.croods.ecommerce.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.service.MainService;
import com.croods.ecommerce.service.EcommerceAdmin.EcommerceAdminService;
import com.croods.ecommerce.service.EcommerceAdmin.EcommerceAdminServiceImpl;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.socialmedia.SocialMediaService;
import com.croods.ecommerce.service.themecolor.EcommerceThemeColorsService;
import com.croods.ecommerce.service.userFront.UserFrontService;
import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;
import com.croods.ecommerce.vo.api.APITokenVo;

import lombok.extern.java.Log;

@Log
@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = { "http://localhost:3000/", "https://shop.vasyerp.com:8443/", "https://shop.vasyerp.com/", "*" })
@RequestMapping("/api/v1/ecommerceadmin")
public class EcomAdminController {


	@Value("${base.url}")
	private String baseUrl;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	APITokenService apiTokenService;

	@Autowired
	UserFrontService userFrontService;

	@Autowired
	SocialMediaService socialMediaService;

	@Autowired
	EcommerceThemeColorsService ecommerceThemeColorsService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	EcommerceAdminService ecommerceAdminService;
	
	@Autowired
	EcommerceAdminServiceImpl ecommerceAdminServiceImpl;
	
//	@GetMapping("/dashboard/count")
//	 public ApiResponse getDasjboardCount(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
//	 ApiResponse apiResponse = new ApiResponse();
//	 Map<String, String> requestBody = new HashMap<>();
//	 String URL = baseUrl.concat(Constant.API + "/dashboard/count");
//	 apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
//	 return apiResponse;
//	 	 
// }
	
	@GetMapping("/dashboard/count")
	public ApiResponse getDashboardCount(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
	    try {
	        ApiResponse apiResponse = new ApiResponse();
	        Map<String, String> requestBody = new HashMap<>();
	        String URL = baseUrl.concat(Constant.API + "/dashboard/count");
	        apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
	        return apiResponse;
	    } catch (Exception e) {
	      
	        return new ApiResponse(false, e.getMessage(), null);
	    }
	}

	@GetMapping("/api/v1/updateecomeercesettings")
	public ApiResponse getBestseller(@RequestHeader(value = "API_TOKEN") String API_TOKEN,
	        @RequestParam (value = "settingsType")String settingsType,@RequestParam(value = "settingsValue") String settingsValue) {
	    APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
	    System.err.println("INSIDE THIS METHOS");
	    
	    EcommerceAdminVo ecommerceAdminVo = null;
	    if (apiToken == null) {
	    	System.err.println("HELLO");
	        return new ApiResponse(false, "No Token Found", null);
	    } else {
	    	System.err.println("INSIDE ELSE ACTUAL PART");
	    	
	    	//check settingsType is blank oor no
	    	
	    	if(StringUtils.isNotBlank(settingsType) && StringUtils.isNotBlank(settingsValue)) {
	    		 // Check if settings exist
		    	long comapnyId = apiToken.getCompanyId();
		    	long branchId = apiToken.getBranchId();
		    	long userId = apiToken.getUserFrontId();
		    	
//		        EcommerceAdminVo ecommerceAdmin = ecommerceAdminService.
//		            .stream()	
//		            .filter(admin -> admin.getType().equals(settingsType))
//		            .findFirst()
//		            .orElse(null);
		    	List<EcommerceAdminVo> ecommerceAdminVos = ecommerceAdminService.
		    			findEcommerceSettingsVos(comapnyId, branchId, userId, settingsType);
		    	
		        
		    	System.err.println("INSIDE ELSE ACTUAL PART SIZEE :: " + ecommerceAdminVos.size());
		    	
		    	if(ecommerceAdminVos.size() > 0) {
		    		
		    		long ecommerceId = ecommerceAdminVos.get(0).getEcommerceAdminId();
		    		//update the obj with value comming forom request
		    		
		    		ecommerceAdminService.updateEcommerceAdminSettingValueById(ecommerceId,settingsValue);
		    		
		    		ecommerceAdminVo = ecommerceAdminVos.get(0);
		    		
		    		
		    	}else {
		    		
		    		  EcommerceAdminVo ecommerceAdminVoNew = new EcommerceAdminVo();
		    		  ecommerceAdminVoNew.setCompanyId(apiToken.getCompanyId());
		    		  ecommerceAdminVoNew.setBranchId(apiToken.getBranchId());
		    		  ecommerceAdminVoNew.setUserId(apiToken.getUserFrontId());
		    		  ecommerceAdminVoNew.setType(settingsType);
		    		  ecommerceAdminVoNew.setValue(settingsValue);  
			          ecommerceAdminVo  = ecommerceAdminService.addEcommerceAdmin(ecommerceAdminVoNew);
		    	}
	    	}else {
	    		
	    		
	    		return new ApiResponse(false, "Settings type or value cannot be blank.", null);

	    	}
	    	
	    	
	       
	    	return new ApiResponse(true, "Settings Found", ecommerceAdminVo);
	    	
	        
	    }
	}
}
