package com.croods.ecommerce.service.themecolor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croods.ecommerce.repo.themecolor.EcommerceThemeColorsRepo;
import com.croods.ecommerce.vo.themecolor.EcommerceThemeColorsVo;

@Service
public class EcommerceThemeColorsServiceImpl implements EcommerceThemeColorsService {

	@Autowired
	EcommerceThemeColorsRepo ecommerceThemeColorsRepo;

	@Override
	public EcommerceThemeColorsVo saveThemeColors(EcommerceThemeColorsVo ecommerceThemeColorsVo) {

		return ecommerceThemeColorsRepo.save(ecommerceThemeColorsVo);
	}

	@Override
	public List<EcommerceThemeColorsVo> findByUserfrontId(long userFrontId) {
		return ecommerceThemeColorsRepo.findByUserfrontId(userFrontId);
	}

}
