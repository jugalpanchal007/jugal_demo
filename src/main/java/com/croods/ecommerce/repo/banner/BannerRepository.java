package com.croods.ecommerce.repo.banner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;
import com.croods.ecommerce.vo.banner.BannerVo;

public interface BannerRepository extends JpaRepository<BannerVo, Long> {

	  @Query(value = "INSERT INTO banner (title, subtitle, src) VALUES (?1, ?2, ?3)", nativeQuery = true)
	    void insertBanner(String title, String subtitle, String src);
	  
	  @Query(value = "SELECT * FROM banner WHERE company_id = :companyId AND branch_id = :branchId AND user_front_id = :userId AND is_deleted=0", nativeQuery = true)
		 List<BannerVo> findBannerVos(@Param("companyId")long companyId,@Param("branchId")long branchId,@Param("userId")long userId);
}
