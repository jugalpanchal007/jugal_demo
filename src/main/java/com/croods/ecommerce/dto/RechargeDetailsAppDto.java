package com.croods.ecommerce.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RechargeDetailsAppDto {

	private String p2pId;
	private long rechargeId;
	private String rechargeToName;
	private double rechargeAmount;
	private String rechargeStatus;
	private Date createdOn;
	private String mode;
}
