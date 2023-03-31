package com.croods.ecommerce.dto.merchant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EcommerceMerchantFetchDetailsDto {

	public String logo;
	public String address;
	public String address2;

	public String contactNo;

	public String email;
	public String token;

	public String description;
	public String allowedGoogleLocationPlaces;
	public String imageServer;
	public String name;
	public String algoliaIndexName;
	public int isRazorPay;
	public int isOrderConfirmationFlowEnabled;
	public long decimalPoints;
	public int isPaytm;
	public String paytmMID;
	public int enableWishlist;
	
}
