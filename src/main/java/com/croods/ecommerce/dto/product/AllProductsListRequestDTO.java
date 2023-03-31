package com.croods.ecommerce.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllProductsListRequestDTO {

	private long companyId;
	private long branchId;
	private long categoryId;
	private long searchValue;
	private int limit;
	private int pageCount;
	
}
