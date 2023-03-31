package com.croods.ecommerce.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ItemVo {

	private long itemId;
	private BrandVo brandVo;
	private CategoryVo categoryVo;
	private String itemName;
	private String itemCode;
	private String hsnCode;
	private String itemOtherName;
	private String itemDescription;
	private TaxVo taxVo;
	private double mrp;
	private double discount;
	private double sellingPrice;
	private int isSalesTaxIncluding;
	private UserFrontVo userFrontVo;
	private int isDeleted;
	private long companyId;
	private long alterBy;
	private long createdBy;
	private Date createdOn;
	private Date modifiedOn;
	private String createdbyname;
	private double weekendPrice;

}
