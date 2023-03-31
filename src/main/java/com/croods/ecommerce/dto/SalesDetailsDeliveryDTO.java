package com.croods.ecommerce.dto;

import java.util.Date;

public interface SalesDetailsDeliveryDTO {
	public long getSalesId();
	public String getSalesNo();
	public String getStatus();
	public String getDeliveryStatus();
	public Date getSalesDate();
	public String getCreatedOn();
	public long getContactId();
	public String getContactName();
	public String getContactNo();
	public String getContactAddress();
	public String getShippingAddress();
	public long getProductVarientId();
	public String getProductName();
	public String getImagePath();
	public float getQty();
	public double getPrice();
	public double getMrp();
	public double getNetAmount();
	public double getTaxAmount();
	public long getTaxId();
	public double getTaxRate();
	public double getDiscount();
	public String getDiscountType();
	public double getSellingPrice();
	public double getUsedCoins();
	public double getTotal();
	public double getPaidAmount();
	public String getPaymentMode();
	public long getCompanyId();
	public long getBranchId();
	public String getBranchName();
}
