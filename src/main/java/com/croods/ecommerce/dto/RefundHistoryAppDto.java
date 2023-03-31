package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RefundHistoryAppDto {

	private String refundToName;
	private double refundAmount;
	private String refundStatus;
	private long refundId;
}
