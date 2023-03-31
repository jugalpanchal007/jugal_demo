package com.croods.ecommerce.service.socialmedia;

import java.util.List;
import java.util.Map;

import com.croods.ecommerce.dto.socialmedia.SocialMediaProjectionDto;
import com.croods.ecommerce.vo.socialmedia.SocialMediaVo;

public interface SocialMediaService {

	String saveSocialMedia(Map<String, String> sociaMediaVos, String userFrontId);
	
	List<SocialMediaVo> findByUserFrontId(long userFrontId);
	
	List<SocialMediaProjectionDto> getSocialMediaCutonListByUserFrontId(long userFrontId);
	
	int deleteAllByUserFrontId(long userFrontId);

	
}
