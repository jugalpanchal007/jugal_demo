package com.croods.ecommerce.service.banner;

import java.util.List;


import com.croods.ecommerce.vo.banner.BannerVo;

public interface BannerService {

	
	
	List<BannerVo> findBannerVos(long companyId,long branchId,long userId);
	
	//List<BannerVo> saveBanner(long companyId,long branchId,long userId);
}
