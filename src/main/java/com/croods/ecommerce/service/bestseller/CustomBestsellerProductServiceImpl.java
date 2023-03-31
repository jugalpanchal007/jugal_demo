package com.croods.ecommerce.service.bestseller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croods.ecommerce.repo.bestseller.CustomBestsellerProductRepository;
import com.croods.ecommerce.vo.bestseller.CustomBestSellerVo;

import lombok.Setter;

@Service
public class CustomBestsellerProductServiceImpl  implements CustomBestsellerProductService{

		@Autowired
	    private CustomBestsellerProductRepository customBestsellerProductRepository;
	
	
	
	@Override
	public CustomBestSellerVo save(CustomBestSellerVo customBestSellerVo) {
		return customBestsellerProductRepository.save(customBestSellerVo);
	}

	@Override
	public List<CustomBestSellerVo> findAll() {
		return customBestsellerProductRepository.findAll();
	}

	@Override
	public Optional<CustomBestSellerVo> findById(Long id) {
        return customBestsellerProductRepository.findById(id);

	}

	@Override
	public void deleteById(Long id) {
		customBestsellerProductRepository.deleteById(id);
		
	}

	

//	@Override
//	public Optional<CustomBestSellerVo> findByPositon(Integer id) {
//		// TODO Auto-generated method stub
//		return customBestsellerProductRepository.findByPositon(id);
//	}

	

	
}
