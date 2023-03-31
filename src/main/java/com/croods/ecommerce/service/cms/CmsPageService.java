package com.croods.ecommerce.service.cms;

import java.util.List;

import com.croods.ecommerce.vo.cms.CmsPageType;
import com.croods.ecommerce.vo.cms.CmsPagesVo;

public interface CmsPageService {

	CmsPagesVo createCmsPage(String type, String content);

	CmsPagesVo getCmsPageById(Long id);

    List<CmsPagesVo> getAllCmsPages();
    
    List<CmsPagesVo> findCmsPagesVos(long companyId,long branchId,long userId);
   
    boolean deleteCmsPage(Long cmsPageId);
    
    CmsPagesVo findCmsPageById(long id);
    CmsPagesVo updateCmsPage(CmsPagesVo cmsPagesVo);
  
    //CmsPagesVo updateCmsPage(long cmsPageId, String cmsPageType, String cmsPageContent);
        
    List<CmsPagesVo> getCmsPagesByCompanyIdAndBranchIdAndUserIdAndCmsPageType(long companyId, long branchId, long userId, String cmsPageType);

 

  
}
