package com.croods.ecommerce.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomBestsellerProductDTO {

	
	private Long productId;
    private Long productVariantId;
    private Integer position;
}
