package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpDTO {

	private String contactId;
	private String contactName;
	private String contactFirstName;
	private String contactLastName;
	private String contactNo;
	private String email;
	private String referralCode;
	private String type;
	private String password;
	private String country;
	private String state;
	private String city;
	private String pincode;
	
}