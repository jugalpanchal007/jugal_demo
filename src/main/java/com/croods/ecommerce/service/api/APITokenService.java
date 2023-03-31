package com.croods.ecommerce.service.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.dto.api.APITokenDTO;
import com.croods.ecommerce.vo.api.APITokenVo;

public interface APITokenService {

	ApiResponse saveApiToken(APITokenDTO aPITokenDTO);
	
	APITokenVo validateToken(Map<String, String> headers, HttpServletRequest request);

	APITokenVo findByTokenAndIsDeleted(String token, int isDeleted);


	APITokenVo findByToken(String token);

}
