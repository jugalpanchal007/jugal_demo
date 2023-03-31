package com.croods.ecommerce.service.bestseller;

import java.util.List;
import java.util.Optional;

import com.croods.ecommerce.vo.bestseller.CustomBestSellerVo;

public interface CustomBestsellerProductService {

	
	
	   CustomBestSellerVo save(CustomBestSellerVo customBestSellerVo);
	    List<CustomBestSellerVo> findAll();
	    Optional<CustomBestSellerVo> findById(Long id);
	    void deleteById(Long id);
		//Optional<CustomBestSellerVo> findByPositon(Integer id);
}
