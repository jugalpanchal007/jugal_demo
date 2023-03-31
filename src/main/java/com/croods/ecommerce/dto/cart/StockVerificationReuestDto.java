package com.croods.ecommerce.dto.cart;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockVerificationReuestDto {

	private List<CartDTO> cartDTOs;
}
