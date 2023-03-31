package com.croods.ecommerce.service.banner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croods.ecommerce.repo.banner.BannerRepository;
import com.croods.ecommerce.vo.banner.BannerVo;

@Service
public class BannerServiceImpl implements BannerService{
	
	
	@Autowired
	BannerRepository bannerRepository;

	@Override
	public List<BannerVo> findBannerVos(long companyId, long branchId, long userId) {
		List<BannerVo> list = new ArrayList<>();
		System.err.println("Company ID: SERVICE IMPL" + companyId + ", Branch ID: " + branchId + ", User ID: " + userId);

		try {
			list = bannerRepository.findBannerVos(companyId, branchId, userId);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	



	
	
	
}
