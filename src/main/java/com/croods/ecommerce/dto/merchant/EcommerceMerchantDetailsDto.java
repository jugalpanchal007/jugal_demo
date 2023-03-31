package com.croods.ecommerce.dto.merchant;

import java.util.List;

import com.croods.ecommerce.dto.socialmedia.SocialMediaProjectionDto;
import com.croods.ecommerce.vo.themecolor.EcommerceThemeColorsVo;

import lombok.Data;

@Data
public class EcommerceMerchantDetailsDto {
	public String logo;
	public String address;
	public String address2;

	public String contactNo;

	public String email;

	public List<SocialMediaProjectionDto> userFrontSocialMediaVos;

	public String token;//

	public String description;
	public String allowedGoogleLocationPlaces;
	public String imageServer;//
	public EcommerceThemeColorsVo themecolors;
	public String name;
	public String algoliaIndexName;//
	public int isRazorPay;//
	public int isOrderConfirmationFlowEnabled;
	public long decimalPoints;
	public int isPaytm;
	public String paytmMID;
	public int enableWishlist;
}
