package com.croods.ecommerce.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundDetailsAppDto {

	private String refundToName;
	private double refundAmount;
	private String refundStatus;
	private long refundId;
	private String refundType;
	private Date refundDate;
}
