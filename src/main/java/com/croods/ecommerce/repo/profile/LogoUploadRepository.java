package com.croods.ecommerce.repo.profile;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.croods.ecommerce.vo.profile.LogoUploadVo;



public interface LogoUploadRepository extends JpaRepository<LogoUploadVo, Long>{

	
	Optional<LogoUploadVo> findById(Long id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE ecommerce_user_front SET logo = :logo, logo_signed_src = :logoSignedSrc WHERE ecommerce_user_front_id = :userId", nativeQuery = true)
	void updateLogoAndLogoSignedSrc(@Param("logo") String logo, @Param("logoSignedSrc") String logoSignedSrc, @Param("userId") long user_id);


}
