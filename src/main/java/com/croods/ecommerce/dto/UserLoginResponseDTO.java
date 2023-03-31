package com.croods.ecommerce.dto;

import lombok.Data;

@Data
public class UserLoginResponseDTO {

	private String contactId;
	private String isSurveyFilled;
	private String contactName;
	private String contactMobileNo;
	private String walletBalance;
	private String signupBonus;

}
