package com.croods.ecommerce.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

	private Date transactionDate;
	private long transactionId;
	private String transactionType;
	private long transactionById;
	private String transactionByName;
	private String transactionNo;
	private long userId;
	private String transactionToName;
	private double debitAmount;
	private double creditAmount;
	private String description;
}
