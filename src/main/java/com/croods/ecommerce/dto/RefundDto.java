package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundDto {

	private String newUser;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String qrcode;
	private String refundToId;
	private String refundById;
	private String refundAmount;
	private String refundType;
	private String refundDescription;
	private String salesId;
	private String rechargeId;

}
