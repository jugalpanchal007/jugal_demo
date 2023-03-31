package com.croods.ecommerce.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartDTO {

	private long productVarientId;
	private Double price;
	private float quantity;
	private long stockId;
	private double subTotal;

}
