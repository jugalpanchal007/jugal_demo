package com.croods.ecommerce.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class SalesPayload {

	
	private long conatctId;
	private long conatctAddressId;
	private List<CartDTO> cartDTOs;
	private String paymentMethod;
	private long companyId;
	private long branchId;
	private long membershipId=0;
	private int ismembership;
	private String note;
	
}
