package com.croods.ecommerce.service.socialmedia;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croods.ecommerce.dto.socialmedia.SocialMediaProjectionDto;
import com.croods.ecommerce.repo.admin.APITokenRepo;
import com.croods.ecommerce.repo.socialmedia.SocialMediaRepo;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.socialmedia.SocialMediaVo;

@Service
public class SocialMediaServiceImpl implements SocialMediaService {

	@Autowired
	SocialMediaRepo socialMediaRepo;

	@Autowired
	APITokenRepo apiTokenRepo;

	@Override
	public String saveSocialMedia(Map<String, String> sociaMediaVos, String userFrontId) {
		// TODO Auto-generated method stub

		String result = "false";

		List<APITokenVo> apitokenList = apiTokenRepo.findByUserFrontId(Long.parseLong(userFrontId));

		if (apitokenList.size() > 0) {
			if (sociaMediaVos != null) {

				if (StringUtils.isNotBlank(sociaMediaVos.get("ecommerceSetupFacebook"))) {

					SocialMediaVo socialMediaVo = new SocialMediaVo();
					socialMediaVo.setSocialMediaType(result);
					socialMediaVo.setSocialMediaLink(result);
					socialMediaVo.setSocialMediaType(result);
					socialMediaVo.setCompanyId(apitokenList.get(0).getCompanyId());
					socialMediaVo.setBranchId(apitokenList.get(0).getBranchId());
					socialMediaVo.setUserFrontId(apitokenList.get(0).getUserFrontId());
					socialMediaVo.setCreatedBy(apitokenList.get(0).getUserFrontId());
					socialMediaVo.setAlterBy(apitokenList.get(0).getUserFrontId());
					socialMediaVo = socialMediaRepo.save(socialMediaVo);
				}

				result = "true";
			} else {

				result = "false";
			}
		} else {

		}

		return null;
	}

	@Override
	public List<SocialMediaVo> findByUserFrontId(long userFrontId) {
		return socialMediaRepo.findByUserFrontId(userFrontId);
	}

	@Override
	public List<SocialMediaProjectionDto> getSocialMediaCutonListByUserFrontId(long userFrontId) {
		return socialMediaRepo.getSocialMediaCutonListByUserFrontId(userFrontId);
	}

	@Override
	public int deleteAllByUserFrontId(long userFrontId) {

		return socialMediaRepo.deleteAllByUserFrontId(userFrontId);
	}

}
