package com.croods.ecommerce.service.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.dto.api.APITokenDTO;
import com.croods.ecommerce.exception.ApiKeyException;
import com.croods.ecommerce.repo.admin.APITokenRepo;
import com.croods.ecommerce.vo.api.APITokenVo;

@Service
public class APITokenServiceImpl implements APITokenService {

	@Autowired
	APITokenRepo apiTokenRepo;

	@Override
	public ApiResponse saveApiToken(APITokenDTO aPITokenDTO) {
		boolean status = false;
		String message = "";
		Object response = null;

		ApiResponse apiResponse = new ApiResponse(status, message, response);

		if (aPITokenDTO != null) {

			APITokenVo apiTokenVo = new APITokenVo();
			APITokenVo apiTokenVoResponse = null;
			apiTokenVo.setUserFrontId(aPITokenDTO.getUserFrontId());
			apiTokenVo.setToken(aPITokenDTO.getToken());
			apiTokenVo.setStatus(aPITokenDTO.getStatus());

			apiTokenVo.setCompanyId(aPITokenDTO.getCompanyId());
			apiTokenVo.setBranchId(aPITokenDTO.getBranchId());
			apiTokenVo.setIsDeleted(aPITokenDTO.getIsDeleted());
			apiTokenVo.setAllowedIpAddresses(aPITokenDTO.getAllowedIpAddresses());

			apiTokenVoResponse = apiTokenRepo.save(apiTokenVo);
			apiResponse = new ApiResponse(true, "Save succesfully", apiTokenVoResponse);
		} else {
			apiResponse = new ApiResponse(status, message, response);
		}

		return apiResponse;
	}

	@Override
	public APITokenVo validateToken(Map<String, String> headers, HttpServletRequest request) {
		// unauthorized
		APITokenVo tokenVo = null;
		try {
			tokenVo = apiTokenRepo.findByTokenAndIsDeleted(headers.get(Constant.API_KEY), 0);
		} catch (Exception e) {
			throw new ApiKeyException("multiple api-key records found");
		}

		// token not found
		if (tokenVo == null)
			throw new ApiKeyException("api-key not found");

		// inactive
		if (tokenVo.getStatus() == 1)
			throw new ApiKeyException("api-key is disabled");

		// IP address validation
		List<String> ipAddresses = (StringUtils.isNotBlank(tokenVo.getAllowedIpAddresses()))
				? Arrays.asList(tokenVo.getAllowedIpAddresses().split("\\s*,\\s*"))
				: new ArrayList<>();

		return tokenVo;
	}

	@Override
	public APITokenVo findByTokenAndIsDeleted(String token, int isDeleted) {
		return apiTokenRepo.findByTokenAndIsDeleted(token, isDeleted);
	}
	
	public APITokenServiceImpl(APITokenRepo apiTokenRepo) {
        this.apiTokenRepo = apiTokenRepo;
    }
	@Override
	public APITokenVo findByToken(String token) {
		// TODO Auto-generated method stub
		 return apiTokenRepo.findByToken(token);
	}

	

}
