package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFrontDto {

	private long userFrontId;
	private String businessName;
	private String qrCodeNo;
	private long companyId;
	private String type;
	private String stallType;
	private String countriesCode;
	private String stateCode;
	private String cityCode;
	private String email;
	private String address;
	private String pincode;
	private String contactName;
	private String userName;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private double walletAmount;
	private int isComplimentary;
	private int isOnlineRefunded;
	private int ismerchandisePos;
	private long voucherId;
	private double VocherTotalAmount;
	private double VocherWalletAmount;
}
