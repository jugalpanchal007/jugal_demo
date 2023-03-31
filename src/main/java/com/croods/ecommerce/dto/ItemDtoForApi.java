package com.croods.ecommerce.dto;

import java.util.Date;

import com.croods.ecommerce.vo.TaxVo;

import lombok.Data;

@Data
public class ItemDtoForApi {

	private long itemId;
	private String itemName;
	private String itemCode;
	private String hsnCode;
	private String itemOtherName;
    private String itemDescription;
    private long taxId;
    private String taxName;
    private double taxRate;
	private double mrp;
	private double discount;
	private double sellingPrice;
	private int isSalesTaxIncluding;
	private int isDeleted;
	private long companyId;
	private long alterBy;
	private long createdBy;
	private Date createdOn;
	private Date modifiedOn;
	private double stockquantity;
	private double weekendPrice;
}
