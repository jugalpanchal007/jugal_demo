package com.croods.ecommerce.repo.EcommerceAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;

@Repository
public interface EcommerceAdminRepo extends JpaRepository<EcommerceAdminVo, Long> {

	 @Query(value = "SELECT * FROM ecommerce_admin WHERE company_id = :companyId AND branch_id = :branchId AND user_id = :userId AND  type = :settingsType ", nativeQuery = true)
	 List<EcommerceAdminVo> findEcommerceSettingsVos(@Param("companyId")long companyId,@Param("branchId")long branchId,@Param("userId")long userId,@Param("settingsType")String settingsType);
//	 
	 @Modifying
	 @Query(value = "UPDATE ecommerce_admin SET value = :settingsValue WHERE company_id = :companyId AND branch_id = :branchId AND user_id = :userId AND type = :settingsType", nativeQuery = true)
	 void updateEcommerceAdminSettingValue(@Param("companyId") long companyId, @Param("branchId") long branchId, @Param("userId") long userId, @Param("settingsType") String settingsType, @Param("settingsValue") String settingsValue);

	@Query("from EcommerceAdminVo where type=?1 and branchId=?2")
	List<EcommerceAdminVo> findByTypeAndBrachId(String type,long branchId);
	
	@Query("from EcommerceAdminVo where userId=?1")
	List<EcommerceAdminVo> findByUserFront(long userForntId);
	
	EcommerceAdminVo findByType(String type);
	
	@Query("from EcommerceAdminVo where userId=?1 and type=?2")
	EcommerceAdminVo findByUserFrontandType(long userForntId,String type);
	
}
