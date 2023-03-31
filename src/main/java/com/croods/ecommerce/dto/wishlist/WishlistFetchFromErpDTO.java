package com.croods.ecommerce.dto.wishlist;

public interface WishlistFetchFromErpDTO {

	public String getWishlistId();

	public String getProductId();

	public String getProductVarientId();

	public int getHaveVariations();
//	private String wishlistId;
//	private String productId;
//	private String productVarientId;
//	private int haveVariations;
	
	public String getProductName();

	public double getMrp();

	public double getSellingPrice();

	public int getIsSaveLater();

	public int getIsDeleted();

	public String getProductImage();

	public long getContactId();

	public long getCompanyId();

	public long getBranchId();
}
