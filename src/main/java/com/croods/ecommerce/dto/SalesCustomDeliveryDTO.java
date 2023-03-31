package com.croods.ecommerce.dto;

import java.util.Date;

public interface SalesCustomDeliveryDTO {

	public long getSalesId();
	public String getSalesNo();
	public String getStatus();
	public String getDeliveryStatus();
	public Date getSalesDate();
	public long getContactId();
	public String getContactName();
	public String getContactNo();
	public double getUsedCoins();
	public String getPaymentMode();
	public long getCompanyId();
	public long getBranchId();
	public String getBranchName();
}
