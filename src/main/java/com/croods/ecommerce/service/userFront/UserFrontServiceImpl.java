package com.croods.ecommerce.service.userFront;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.dto.merchant.MerchantDTO;
import com.croods.ecommerce.repo.admin.APITokenRepo;
import com.croods.ecommerce.repo.socialmedia.SocialMediaRepo;
import com.croods.ecommerce.repo.userfront.UserFrontRepo;
import com.croods.ecommerce.service.MainService;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.socialmedia.SocialMediaVo;
import com.croods.ecommerce.vo.userfront.EcommerceUserfrontVo;

import lombok.extern.java.Log;

@Log
@Service
public class UserFrontServiceImpl implements UserFrontService {

	@Autowired
	UserFrontRepo userFrontRepo;

	@Autowired
	APITokenRepo apiTokenRepo;

	@Autowired
	SocialMediaRepo socialMediaRepo;

	@Autowired
	MainService mainService;

	@Autowired
	RestTemplate restTemplate;

	@Value("${base.url}")
	private String baseUrl;

	@Override
	public EcommerceUserfrontVo save(MerchantDTO merchantDTO) {
		EcommerceUserfrontVo ecommerceUserfrontVoGlobal = new EcommerceUserfrontVo();

		if (merchantDTO != null) {

			if (merchantDTO.getEcommerceUserfrontId() != 0) {
				ecommerceUserfrontVoGlobal.setEcommerceUserfrontId(merchantDTO.getEcommerceUserfrontId());
			}
			ecommerceUserfrontVoGlobal.setCompanyId(merchantDTO.getCompanyId());
			ecommerceUserfrontVoGlobal.setBranchId(merchantDTO.getBranchId());
			ecommerceUserfrontVoGlobal.setCountriesCode(merchantDTO.getCountriesCode());
			ecommerceUserfrontVoGlobal.setCountriesName(merchantDTO.getCountriesName());
			ecommerceUserfrontVoGlobal.setDescription(merchantDTO.getDescription());
			ecommerceUserfrontVoGlobal.setZoneCode(merchantDTO.getZoneCode());
			ecommerceUserfrontVoGlobal.setStateCode(merchantDTO.getStateCode());
			ecommerceUserfrontVoGlobal.setStateName(merchantDTO.getStateName());
			ecommerceUserfrontVoGlobal.setCityCode(merchantDTO.getCityCode());
			ecommerceUserfrontVoGlobal.setCityName(merchantDTO.getCityName());
			ecommerceUserfrontVoGlobal.setName(merchantDTO.getName());
			ecommerceUserfrontVoGlobal.setEmail(merchantDTO.getEmail());
			ecommerceUserfrontVoGlobal.setAddress(merchantDTO.getAddress());
			ecommerceUserfrontVoGlobal.setAddress2(merchantDTO.getAddress2());
			ecommerceUserfrontVoGlobal.setPincode(merchantDTO.getPincode());
			ecommerceUserfrontVoGlobal.setFssaiNo(merchantDTO.getFssaiNo());
			ecommerceUserfrontVoGlobal.setPanNo(merchantDTO.getPanNo());
			ecommerceUserfrontVoGlobal.setTelephone(merchantDTO.getTelephone());
			ecommerceUserfrontVoGlobal.setStatus(merchantDTO.getStatus());
			ecommerceUserfrontVoGlobal.setLogo(merchantDTO.getLogo());
			ecommerceUserfrontVoGlobal.setLogoSignedSrc(merchantDTO.getLogo());
			ecommerceUserfrontVoGlobal.setHostName(merchantDTO.getHostName());
			ecommerceUserfrontVoGlobal.setAllowedGoogleLocationPlaces(merchantDTO.getAllowedGoogleLocationPlaces());
			ecommerceUserfrontVoGlobal.setErpUserfrontId(merchantDTO.getErpUserfrontId());

		}

		EcommerceUserfrontVo ecommerceUserfrontVo = userFrontRepo.save(ecommerceUserfrontVoGlobal);

		if (ecommerceUserfrontVo != null) {

			if (StringUtils.isNotBlank(merchantDTO.getToken())) {

				APITokenVo tokenVo = new APITokenVo();
				APITokenVo apiTokenVo = null;

				tokenVo.setUserFrontId(ecommerceUserfrontVo.getEcommerceUserfrontId());
				tokenVo.setErpUserFrontId(ecommerceUserfrontVo.getErpUserfrontId());
				tokenVo.setCompanyId(ecommerceUserfrontVo.getCompanyId());
				tokenVo.setBranchId(ecommerceUserfrontVo.getBranchId());
				tokenVo.setStatus(0);
				tokenVo.setToken(merchantDTO.getToken());
				apiTokenVo = apiTokenRepo.save(tokenVo);

				try {
					ApiResponse apiResponseForToken = new ApiResponse(false, "FAILED", null);
					Map<String, String> requestBody = new HashMap<>();

					String URL = baseUrl.concat(Constant.API + "/user/setEcommerceAdmin/default");
					apiResponseForToken = mainService.getCommonResponseForPostAPI(merchantDTO.getToken(), requestBody,
							URL);

					if (apiResponseForToken.isStatus()) {
						log.info(apiResponseForToken.toString());
					} else {
						log.severe("API RESPONNSE FOR ADMIN DEFAULT : " + apiResponseForToken.toString());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		}

		if (merchantDTO.getSocialMediaVos().size() > 0) {

			try {

				socialMediaRepo.deleteAllByUserFrontId(ecommerceUserfrontVo.getEcommerceUserfrontId());

				if (ecommerceUserfrontVo != null) {
					for (int i = 0; i < merchantDTO.getSocialMediaVos().size(); i++) {
						SocialMediaVo socialMediaVo = new SocialMediaVo();
						socialMediaVo.setSocialMediaType(merchantDTO.getSocialMediaVos().get(i).getSocialMediaType());
						socialMediaVo.setSocialMediaLink(merchantDTO.getSocialMediaVos().get(i).getSocialMediaLink());
						socialMediaVo.setCompanyId(ecommerceUserfrontVo.getCompanyId());
						socialMediaVo.setBranchId(ecommerceUserfrontVo.getBranchId());
						socialMediaVo.setUserFrontId(ecommerceUserfrontVo.getEcommerceUserfrontId());
						socialMediaVo.setCreatedBy(ecommerceUserfrontVo.getEcommerceUserfrontId());
						socialMediaVo.setAlterBy(ecommerceUserfrontVo.getEcommerceUserfrontId());
						socialMediaVo = socialMediaRepo.save(socialMediaVo);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ecommerceUserfrontVoGlobal;
	}

	@Override
	public EcommerceUserfrontVo findByEcommerceUserfrontIdAndIsDeleted(long commerceUserfrontId, int isDeleted) {

		EcommerceUserfrontVo ecommerceUserfrontVo = null;
		try {
			ecommerceUserfrontVo = userFrontRepo.findByEcommerceUserfrontIdAndIsDeleted(commerceUserfrontId, isDeleted);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ecommerceUserfrontVo;
	}

}
