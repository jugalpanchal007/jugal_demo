package com.croods.ecommerce.dto.merchant;

import java.util.List;

import com.croods.ecommerce.dto.socialmedia.SocialMediaDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MerchantDTO {

	private long ecommerceUserfrontId;

	private long companyId;
	
	private long branchId;

	private String countriesCode;

	private String description;

	private String countriesName;

	private String zoneCode;

	private String stateCode;

	private String stateName;

	private String cityCode;

	private String cityName;

	private String name;

	private String email;

	private String address;

	private String address2;

	private String pincode;

	private String contactNo;

	private String fssaiNo;

	private String panNo;

	private String telephone;

	private String status;

	private int isDeleted;

	private String logo;

	private String hostName;

	private String allowedGoogleLocationPlaces;

	private long erpUserfrontId;
	
	private String token;
	
	List<SocialMediaDto> socialMediaVos;
	
	
}
