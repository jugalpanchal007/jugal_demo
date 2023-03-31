package com.croods.ecommerce.dto.wishlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WishlistSaveDTO {

	//private long wishlistId;
	private long contactId;
	private long productVarientId;
	private long productId;
	private long categoryId;
	private long brandId;
	private String productName;
	private String image;
	private double mrp;
	private double sellingPrice;
//	private int isSavelater;
	private int haveVariations;
}
