package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeDto {

	private String newUser;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String qrcode;
	private String rechargeToId;
	private String rechargeById;
	private String rechargeAmount;
	private String rechargeDescription;
	private String rechargeType;
	private String rechargeDeviceId;
}
