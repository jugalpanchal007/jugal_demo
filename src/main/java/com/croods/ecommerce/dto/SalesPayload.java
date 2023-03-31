package com.croods.ecommerce.dto;

import java.util.List;

import com.croods.ecommerce.dto.cart.CartDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesPayload {

	private long conatctId;
	private long conatctAddressId;
	private long billingConatctAddressId;
	private long shipingConatctAddressId;
	private List<CartDTO> cartDTOs;
	private String paymentMethod;
	private double usedCoins;
	private String branchId;
	private String razorPaymentId;
	private String paymentUniqNo;
	private String paymentTxnId;
	
}
