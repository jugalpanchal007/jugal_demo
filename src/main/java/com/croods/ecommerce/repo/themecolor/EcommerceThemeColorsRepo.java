package com.croods.ecommerce.repo.themecolor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.croods.ecommerce.vo.themecolor.EcommerceThemeColorsVo;

@Repository
public interface EcommerceThemeColorsRepo extends JpaRepository<EcommerceThemeColorsVo, Long> {

	
	List<EcommerceThemeColorsVo> findByUserfrontId(long userFrontId);

}
