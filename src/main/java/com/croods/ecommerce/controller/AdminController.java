package com.croods.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.dto.api.APITokenDTO;
import com.croods.ecommerce.dto.merchant.MerchantDTO;
import com.croods.ecommerce.dto.themecolor.EcommerceThemeColorsDto;
import com.croods.ecommerce.service.MainService;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.socialmedia.SocialMediaService;
import com.croods.ecommerce.service.themecolor.EcommerceThemeColorsService;
import com.croods.ecommerce.service.userFront.UserFrontService;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.themecolor.EcommerceThemeColorsVo;
import com.croods.ecommerce.vo.userfront.EcommerceUserfrontVo;

import lombok.extern.java.Log;

@Log
@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = { "http://localhost:3000/", "https://shop.vasyerp.com:8443/", "https://shop.vasyerp.com/", "*" })
@RequestMapping("/api/v1")
public class AdminController {

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
//	1. Generate The API Token Same As In ERP DB
//	2. Save Ecommerce User Front
//	3. Save Social Media
//	4. Save Banners Api
//	5. Save Theme Color
//	6. Get Ecommerce Merchant Details API

//	1. Generate The API Token Same As In ERP DB ///// START /////
	@RequestMapping("/admin/token/save")
	public ApiResponse saveAPITokenForMerchant(HttpSession session, @RequestBody APITokenDTO aPITokenDTO) {

		ApiResponse apiResponse = new ApiResponse();
		apiResponse = apiTokenService.saveApiToken(aPITokenDTO);
		log.severe("....." + apiResponse);

		return apiResponse;
	}

//	1. Generate The API Token Same As In ERP DB ///// ENDS /////

//	2. Save Ecommerce User Front ///// START /////
	@RequestMapping("/admin/merchant/save")
	public ApiResponse saveMerchantDetailsFromERP(HttpSession session, @RequestBody MerchantDTO merchantDTO) {

		ApiResponse apiResponse = new ApiResponse();
		EcommerceUserfrontVo ecommerceUserfrontVo = userFrontService.save(merchantDTO);
		log.severe("....." + apiResponse);
		if (ecommerceUserfrontVo != null) {

			Map<String, String> map = new HashMap<>();

			map.put("ecommerceUserfrontId", String.valueOf(ecommerceUserfrontVo.getEcommerceUserfrontId()));
			map.put("erpUserfrontId", String.valueOf(ecommerceUserfrontVo.getErpUserfrontId()));

			apiResponse = new ApiResponse(true, "Save Successfully...!!!", map);
		} else {
			apiResponse = new ApiResponse(false, "Something went wrong...!!!", null);
		}

		return apiResponse;
	}

//	2. Save Ecommerce User Front ///// ENDS /////

//	6. Get Ecommerce Merchant Details API ///// START /////

	@RequestMapping("/admin/merchant/{userFrontId}")
	public ApiResponse getMerchantDetails(HttpSession session, @PathVariable("userFrontId") String userFrontId) {

		ApiResponse apiResponse = new ApiResponse();
		EcommerceUserfrontVo ecommerceUserfrontVo = null;
		if (StringUtils.isNotBlank(userFrontId)) {
			ecommerceUserfrontVo = userFrontService.findByEcommerceUserfrontIdAndIsDeleted(Long.parseLong(userFrontId),
					0);
		}

		if (ecommerceUserfrontVo != null) {
			ecommerceUserfrontVo.setSocialMediaVos(socialMediaService.findByUserFrontId(Long.parseLong(userFrontId)));
			apiResponse = new ApiResponse(true, "Save Successfully...!!!", ecommerceUserfrontVo);
		} else {
			apiResponse = new ApiResponse(false, "Something went wrong...!!!", null);
		}

		log.severe("getMerchantDetails :: " + apiResponse);
		return apiResponse;
	}

//	6. Get Ecommerce Merchant Details API ///// ENDS /////

	@RequestMapping("/admin/merchant/{userFrontId}/socialmedia/save")
	public ApiResponse ecommerceMerchantSocialMediaSave(HttpSession session,
			@PathVariable("userFrontId") String userFrontId, @RequestBody Map<String, String> sociaMediaVos) {

		ApiResponse apiResponse = new ApiResponse();
		String result = "false";
		if (sociaMediaVos != null) {

			result = socialMediaService.saveSocialMedia(sociaMediaVos, userFrontId);
		}

//		if (ecommerceUserfrontVo != null) {
//			apiResponse = new ApiResponse(true, "Save Successfully...!!!", ecommerceUserfrontVo);
//		} else {
//			apiResponse = new ApiResponse(false, "Something went wrong...!!!", null);
//		}
//
//		log.severe("getMerchantDetails :: " + apiResponse);
		return apiResponse;
	}

	@PostMapping("/admin/merchant/themecolor/save")
	public ApiResponse ecommerceMerchantThemeColorSave(HttpSession session,
			@RequestBody EcommerceThemeColorsDto ecommerceThemeColorsDto, @RequestHeader Map<String, String> headers,
			HttpServletRequest request) {

		ApiResponse apiResponse = new ApiResponse();

		APITokenVo tokenVo = apiTokenService.validateToken(headers, request);

		try {
			long userFrontId = tokenVo.getUserFrontId();

			if (ecommerceThemeColorsDto != null) {

				EcommerceThemeColorsVo themeColorVo = new EcommerceThemeColorsVo();

				List<EcommerceThemeColorsVo> ecommerceThemeColoeList = ecommerceThemeColorsService
						.findByUserfrontId(userFrontId);

				if (ecommerceThemeColoeList.size() > 0) {
					themeColorVo = ecommerceThemeColoeList.get(0);
				}

				themeColorVo.setUserfrontId(userFrontId);
				themeColorVo.setPrimaryColor(ecommerceThemeColorsDto.getPrimaryColor());
				themeColorVo.setSecondaryColor(ecommerceThemeColorsDto.getSecondaryColor());
				themeColorVo.setHeadingColor(ecommerceThemeColorsDto.getHeadingColor());
				themeColorVo.setFooterColor(ecommerceThemeColorsDto.getFooterColor());
				themeColorVo.setFooterTextColor(ecommerceThemeColorsDto.getFooterTextColor());

				EcommerceThemeColorsVo themeColorVoNew = ecommerceThemeColorsService.saveThemeColors(themeColorVo);

				if (themeColorVoNew != null) {
					apiResponse = new ApiResponse(true, "Save Succesfully", themeColorVoNew);
				} else {
					apiResponse = new ApiResponse(false, "Error in Save", null);
				}

			} else {
				apiResponse = new ApiResponse(false, "Ecommerce UserFrontId not found", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			apiResponse = new ApiResponse(false, e.getMessage(), null);
		}

		return apiResponse;
	}

	@PostMapping("/admin/merchant/get/themecolor")
	public ApiResponse getEcommerceMerchantThemeColor(HttpSession session, @RequestHeader Map<String, String> headers,
			HttpServletRequest request) {

		ApiResponse apiResponse = new ApiResponse();

		APITokenVo tokenVo = apiTokenService.validateToken(headers, request);

		try {
			long userFrontId = tokenVo.getUserFrontId();

			List<EcommerceThemeColorsVo> ecommerceThemeColoeList = ecommerceThemeColorsService
					.findByUserfrontId(userFrontId);

			if (ecommerceThemeColoeList.size() > 0) {

				apiResponse = new ApiResponse(true, "Found Successfully...!!!", ecommerceThemeColoeList.get(0));
			} else {
				apiResponse = new ApiResponse(false, "Failed Not found...!!!", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			apiResponse = new ApiResponse(false, e.getMessage(), null);
		}

		return apiResponse;
	}

}
