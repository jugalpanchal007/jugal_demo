package com.croods.ecommerce.repo.bestseller;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.croods.ecommerce.vo.bestseller.CustomBestSellerVo;

public interface CustomBestsellerProductRepository extends JpaRepository<CustomBestSellerVo, Long>{

	

}
