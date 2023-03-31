package com.croods.ecommerce.service.cms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.croods.ecommerce.repo.cms.CmsPageRepository;

import com.croods.ecommerce.vo.cms.CmsPageType;
import com.croods.ecommerce.vo.cms.CmsPagesVo;

@Service
public class CmsPageServiceImpl  implements CmsPageService {

	@Autowired
	CmsPageRepository cmsPageRepository;
	
	
	@Override
	public CmsPagesVo createCmsPage(String type, String content) {
		CmsPagesVo cmsPage = new CmsPagesVo();
	        cmsPage.setCmsPageType(CmsPageType.valueOf(type.toUpperCase()));
	        cmsPage.setCmsPageContent(content);
	        return cmsPageRepository.save(cmsPage);
	}

	@Override
	public CmsPagesVo getCmsPageById(Long id) {
		 return cmsPageRepository.findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CMS Page not found"));
	}

	@Override
	public List<CmsPagesVo> getAllCmsPages() {
		 return cmsPageRepository.findAll();
	}

	@Override
	public List<CmsPagesVo> findCmsPagesVos(long companyId, long branchId, long userId) {
		List<CmsPagesVo> list = new ArrayList<>();
		System.err.println("Company ID: " + companyId + ", Branch ID: " + branchId + ", User ID: " + userId);

		try {
			list = cmsPageRepository.findCmsPagesVos(companyId, branchId, userId);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CmsPagesVo> getCmsPagesByCompanyIdAndBranchIdAndUserIdAndCmsPageType(long companyId, long branchId,
			long userId, String cmsPageType) {
		  List<CmsPagesVo> cmsPages = cmsPageRepository.findByCompanyIdAndBranchIdAndUserIdAndCmsPageType(companyId, branchId, userId, cmsPageType);
//		  List<CmsPagesVo> cmsPagesVoList = cmsPages.stream().map(cmsPage -> {
//			    CmsPagesVo cmsPagesVo = new CmsPagesVo();
//			  
//			    cmsPagesVo.setCompanyId(cmsPage.getCompanyId());
//			    cmsPagesVo.setBranchId(cmsPage.getBranchId());
//			    cmsPagesVo.setUserFrontId(cmsPage.getUserFrontId());
//			    cmsPagesVo.setCmsPageType(cmsPage.getCmsPageType());
//			    //cmsPagesVo.set(cmsPage.getContent());
//			    cmsPagesVo.setCmsPageContent(cmsPage.getCmsPageContent());
//			    return cmsPagesVo;
//			}).collect(Collectors.toList());
		  return cmsPages;
	}

	@Override
	public boolean deleteCmsPage(Long cmsPageId) {
		 Optional<CmsPagesVo> optionalCmsPage = cmsPageRepository.findById(cmsPageId);
	        if (optionalCmsPage.isPresent()) {
	            cmsPageRepository.delete(optionalCmsPage.get());
	            return true;
	        } else {
	            return false;
	        }
	}
	  @Override
	    public CmsPagesVo findCmsPageById(long id) {
	        Optional<CmsPagesVo> cmsPage = cmsPageRepository.findById(id);
	        if (cmsPage.isPresent()) {
	            return mapToCmsPagesVo(cmsPage.get());
	        }
	        return null;
	    }

	    @Override
	    public CmsPagesVo updateCmsPage(CmsPagesVo cmsPagesVo) {
	    	CmsPagesVo cmsPage = mapToCmsPage(cmsPagesVo);
	    	CmsPagesVo updatedCmsPage = cmsPageRepository.save(cmsPage);
	        return mapToCmsPagesVo(updatedCmsPage);
	    }

	    
	    private CmsPagesVo mapToCmsPage(CmsPagesVo cmsPagesVo) {
	    	CmsPagesVo cmsPage = new CmsPagesVo();
	        cmsPage.setCmsPageId(cmsPagesVo.getCmsPageId());
	        cmsPage.setCmsPageType(cmsPagesVo.getCmsPageType());
	        cmsPage.setCmsPageContent(cmsPagesVo.getCmsPageContent());
	        return cmsPage;
	    }

	    private CmsPagesVo mapToCmsPagesVo(CmsPagesVo cmsPage) {
	        CmsPagesVo cmsPagesVo = new CmsPagesVo();
	        cmsPagesVo.setCmsPageId(cmsPagesVo.getCmsPageId());
	        cmsPagesVo.setCmsPageType(cmsPagesVo.getCmsPageType());
	        cmsPagesVo.setCmsPageContent(cmsPage.getCmsPageContent());
	        return cmsPagesVo;
	    }





	



	



	
		

}
