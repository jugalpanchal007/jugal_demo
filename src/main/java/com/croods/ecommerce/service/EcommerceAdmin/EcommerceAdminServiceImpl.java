package com.croods.ecommerce.service.EcommerceAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.croods.ecommerce.constant.EcommerceCompanySettingConstant;
import com.croods.ecommerce.repo.EcommerceAdmin.EcommerceAdminRepo;
import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;
import com.croods.ecommerce.vo.api.APITokenVo;

@Service
public class EcommerceAdminServiceImpl implements EcommerceAdminService{

	@Autowired
	EcommerceAdminRepo ecommerceAdminRepo;
	
	@Override
	public void addDefaultValuetoAdminPannel(long branchId, long compnayId, long userFrontID) {
		List<EcommerceAdminVo> adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.topSellingLimt,branchId);
		EcommerceAdminVo adminVo = new EcommerceAdminVo();
		if(adminVofind.size()==0) {
			adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);			
			adminVo.setType(EcommerceCompanySettingConstant.topSellingLimt);
			adminVo.setValue(EcommerceCompanySettingConstant.topSellingLimtDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.topSellingDuration,branchId);
		if(adminVofind.size()==0) {
			adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);			
			adminVo.setType(EcommerceCompanySettingConstant.topSellingDuration);
			adminVo.setValue(EcommerceCompanySettingConstant.topSellingDurationDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.topSellingCategoryDuration,branchId);
		if(adminVofind.size()==0) {
			 adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);
			
			adminVo.setType(EcommerceCompanySettingConstant.topSellingCategoryDuration);
			adminVo.setValue(EcommerceCompanySettingConstant.topSellingCategoryDurationDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.newProductDuration,branchId);
		if(adminVofind.size()==0) {
			 adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);
			
			adminVo.setType(EcommerceCompanySettingConstant.newProductDuration);
			adminVo.setValue(EcommerceCompanySettingConstant.newProductDurationDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.topSellingProductLimt,branchId);
		if(adminVofind.size()==0) {
			 adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);
			
			adminVo.setType(EcommerceCompanySettingConstant.topSellingProductLimt);
			adminVo.setValue(EcommerceCompanySettingConstant.topSellingProductLimtDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.estimateDeliveryTime,branchId);
		if(adminVofind.size()==0) {
			adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);
			
			adminVo.setType(EcommerceCompanySettingConstant.estimateDeliveryTime);
			adminVo.setValue(EcommerceCompanySettingConstant.estimateDeliveryTimeDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.estimateDeliveryType,branchId);
		if(adminVofind.size()==0) {
			 adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);
			
			adminVo.setType(EcommerceCompanySettingConstant.estimateDeliveryType);
			adminVo.setValue(EcommerceCompanySettingConstant.estimateDeliveryTypeDefaulValue);
			ecommerceAdminRepo.save(adminVo);
			
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.categoryFetchLimit,branchId);
		if(adminVofind.size()==0) {
			 adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);
			
			adminVo.setType(EcommerceCompanySettingConstant.categoryFetchLimit);
			adminVo.setValue(EcommerceCompanySettingConstant.categoryFetchLimitDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		adminVofind=ecommerceAdminRepo.findByTypeAndBrachId(EcommerceCompanySettingConstant.productFetchLimit,branchId);
		if(adminVofind.size()==0) {
			 adminVo = new EcommerceAdminVo();
			adminVo.setBranchId(branchId);
			adminVo.setCompanyId(compnayId);
			adminVo.setUserId(userFrontID);			
			adminVo.setType(EcommerceCompanySettingConstant.productFetchLimit);
			adminVo.setValue(EcommerceCompanySettingConstant.productFetchLimitDefaulValue);
			ecommerceAdminRepo.save(adminVo);
		}
		System.out.print("All Done");
	}

	@Override
	public List<EcommerceAdminVo> getEcommerceAdminSeting(long userFrontID) {
		// TODO Auto-generated method stub
		return ecommerceAdminRepo.findByUserFront(userFrontID);
	}
	
	
	@Override
	public EcommerceAdminVo setEcommerceAdminSeting(APITokenVo apiTokenVo,EcommerceAdminVo adminVo) {
		// TODO Auto-generated method stub
		EcommerceAdminVo adminVoEcommerceAdminVo=ecommerceAdminRepo.findByUserFrontandType(apiTokenVo.getUserFrontId(),adminVo.getType());
		if(adminVoEcommerceAdminVo!=null) {
			adminVoEcommerceAdminVo.setValue(adminVo.getValue());
		}else {
			adminVoEcommerceAdminVo.setUserId(apiTokenVo.getUserFrontId());
			adminVoEcommerceAdminVo.setCompanyId(apiTokenVo.getCompanyId());
			adminVoEcommerceAdminVo.setBranchId(apiTokenVo.getBranchId());
			adminVoEcommerceAdminVo.setType(adminVo.getType());
			adminVoEcommerceAdminVo.setValue(adminVo.getValue());
			
		}
		ecommerceAdminRepo.save(adminVoEcommerceAdminVo);
		return ecommerceAdminRepo.findByUserFrontandType(apiTokenVo.getUserFrontId(),adminVo.getType());
	}
	/*
	 * @Override public EcommerceAdminVo setEcommerceAdminSeting(long
	 * userFrontID,String type,String value) { // TODO Auto-generated method stub
	 * return ecommerceSettingRepository.findByType(userFrontID); }
	 */

	@Override
	  public void updateEcommerceAdminSettingValueById(long settingId, String newValue) {
		 try {
	            EcommerceAdminVo entity = ecommerceAdminRepo.findById(settingId).get();
	            entity.setValue(newValue);
	            ecommerceAdminRepo.save(entity);
	        } catch (NoSuchElementException e) {
	            throw new EmptyResultDataAccessException("Setting not found", 1);
	        }
    }

	@Override
	public EcommerceAdminVo addEcommerceAdmin(EcommerceAdminVo ecommerceAdmin) {
		return ecommerceAdminRepo.save(ecommerceAdmin);
    }

	@Override
	public List<EcommerceAdminVo> findEcommerceSettingsVos(long companyId, long branchId, long userId,
			String settingsType) {
		List<EcommerceAdminVo> list = new ArrayList<>();
		try {
			list = ecommerceAdminRepo.findEcommerceSettingsVos(companyId, branchId, userId, settingsType);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	

}
