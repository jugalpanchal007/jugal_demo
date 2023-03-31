package com.croods.ecommerce.repo.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.croods.ecommerce.vo.api.APITokenVo;

@Repository
public interface APITokenRepo extends JpaRepository<APITokenVo, Long> {

	List<APITokenVo> findByUserFrontId(long userfrontId);

	APITokenVo findByTokenAndIsDeleted(String token, int isDeleted);
	
	
	APITokenVo findByToken(String token);

}
