package com.croods.ecommerce.vo;

import lombok.Data;

@Data
public class ProductVo {
	
	  //  public Object defaultImageSrc;
	    public int productId;
	    public int shopifySourceId;
	    public int haveVariation;
	    public int haveDesignno;
	    public String name;
	    public int active;
	    public int shopifySync;
	    public CategoryVo categoryVo;
	    public BrandVo brandVo;
	    public String type;
	    public int companyId;
	    public int branchId;
	    public int alterBy;
	    public int createdBy;
	    public int isDeleted;
	    public String createdOn;
	    public String modifiedOn;
	    public String description;
	    public String displayName;
	    public Object ingredients;
	    public Object expirationdays;
	    public Object netweight;
	    public String productBelong;
	    public Object tag;
	    public String hsnCode;
	    public TaxVo taxVo;
	   // public PurchaseTaxVo purchaseTaxVo;
	    public UnitOfMeasurementVo unitOfMeasurementVo;
	    public Object productCode;
	    public int taxIncluded;
	    public int purchaseTaxIncluded;
	    public Object priceWiseTax;
	   // public List<Object> productAttributeVos;
	    //public List<Object> productNutritionVos;
	    public ProductVarientsVo productVarientsVos;
	    public String discountType;
	    public double discount;
	    public double stock_limit;
	    public double qtyOfProduct;
	    public int taxId;
	    public int purchaseTaxId;
	    public int categoryId;
	    public int brandId;
	    public int measurementId;

	

//	public class Group{
//	    public int accountGroupId;
//	    public String accountGroupName;
//	    public String groupType;
//	    public String keyword;
//	}
//
//	public class AccountCustomVo{
//	    public int accountCustomId;
//	    public Group group;
//	    public int companyId;
//	    public int branchId;
//	    public int alterBy;
//	    public int createdBy;
//	    public String accountName;
//	    public int isDeleted;
//	    public int isUpdatable;
//	    public String accounType;
//	    public String createdOn;
//	    public String modifiedOn;
//	}
//
//	
//

//

//
//	public class PurchaseTaxVo{
//	    public int taxId;
//	    public String taxName;
//	    public int isDeleted;
//	    public double taxRate;
//	    public int companyId;
//	    public int branchId;
//	    public int alterBy;
//	    public int createdBy;
//	    public String createdOn;
//	    public Object modifiedOn;
//	    public AccountCustomVo2 accountCustomVo;
//	    public int isDefault;
//	    public Object createdbyname;
//	}
//


}
