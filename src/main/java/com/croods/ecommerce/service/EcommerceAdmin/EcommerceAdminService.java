package com.croods.ecommerce.service.EcommerceAdmin;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;
import com.croods.ecommerce.vo.api.APITokenVo;

public interface EcommerceAdminService {

	public void addDefaultValuetoAdminPannel(long branchId, long CompnayId, long userFrontID);
	
	public List<EcommerceAdminVo> getEcommerceAdminSeting(long userFrontID);
	
	public EcommerceAdminVo setEcommerceAdminSeting(APITokenVo apiTokenVo,EcommerceAdminVo adminVo);
	
	public EcommerceAdminVo addEcommerceAdmin(EcommerceAdminVo ecommerceAdmin);
	
	public void updateEcommerceAdminSettingValueById(long settingId, String newValue);

	 List<EcommerceAdminVo> findEcommerceSettingsVos(long companyId,long branchId,long userId,String settingsType);

}
