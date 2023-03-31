package com.croods.ecommerce.vo;

import java.util.Date;

import lombok.Data;

@Data
public class TaxVo {

	private long taxId;
	private String taxName;
	private double taxRate;
	private int isDeleted;
	private int isDefault;
	private long companyId;
	private long alterBy;
	private long createdBy;
	private Date createdOn;
	private Date modifiedOn;
}
