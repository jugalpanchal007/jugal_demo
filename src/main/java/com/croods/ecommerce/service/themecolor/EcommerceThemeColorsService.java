package com.croods.ecommerce.service.themecolor;

import java.util.List;

import com.croods.ecommerce.vo.themecolor.EcommerceThemeColorsVo;

public interface EcommerceThemeColorsService {

	EcommerceThemeColorsVo saveThemeColors(EcommerceThemeColorsVo ecommerceThemeColorsVo);
	
	List<EcommerceThemeColorsVo> findByUserfrontId(long userFrontId);
}
