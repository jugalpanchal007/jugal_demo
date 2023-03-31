package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RazorPayDto {

	private String razorpay_invoice_id;
	private String razorpay_payment_id;
	private String razorpay_invoice_status;
	private String razorpay_invoice_receipt;

}