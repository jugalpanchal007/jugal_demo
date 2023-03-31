package com.croods.ecommerce.repo.socialmedia;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.croods.ecommerce.dto.socialmedia.SocialMediaProjectionDto;
import com.croods.ecommerce.vo.socialmedia.SocialMediaVo;

@Repository
public interface SocialMediaRepo extends JpaRepository<SocialMediaVo, Long>{

	List<SocialMediaVo> findByUserFrontId(long userFrontId);
	
	@Query(value = "select \n"
			+ "social_media_link as value,\n"
			+ "social_media_type as type\n"
			+ "from social_media \n"
			+ "where user_front_id = ?1" ,nativeQuery = true)
	List<SocialMediaProjectionDto> getSocialMediaCutonListByUserFrontId(long userFrontId);
	
	@Query(value = "Delete from social_media where user_front_id = ?1" ,nativeQuery = true)
	@Modifying
	@Transactional
	int deleteAllByUserFrontId(long userFrontId);
	
}
