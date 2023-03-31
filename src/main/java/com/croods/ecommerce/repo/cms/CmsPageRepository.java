package com.croods.ecommerce.repo.cms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.croods.ecommerce.vo.cms.CmsPageType;
import com.croods.ecommerce.vo.cms.CmsPagesVo;

@Repository
public interface CmsPageRepository extends JpaRepository<CmsPagesVo, Long> {
	
	@Query(value = "SELECT * FROM cms_pages WHERE company_id = :companyId AND branch_id = :branchId AND user_front_id = :userId AND is_deleted=0", nativeQuery = true)
	 List<CmsPagesVo> findCmsPagesVos(@Param("companyId")long companyId,@Param("branchId")long branchId,@Param("userId")long userId);

	


	 @Query(value = "SELECT * FROM cms_pages WHERE company_id = :companyId AND branch_id = :branchId AND user_front_id = :userId AND cms_page_type = :type", nativeQuery = true)
	    List<CmsPagesVo> findByCompanyIdAndBranchIdAndUserIdAndCmsPageType(@Param("companyId") long companyId, @Param("branchId") long branchId, @Param("userId") long userId, @Param("type") String cmsPageType);


}
