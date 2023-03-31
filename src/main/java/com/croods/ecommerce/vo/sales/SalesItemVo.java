package com.croods.ecommerce.vo.sales;

import com.croods.ecommerce.vo.ProductVarientsVo;
import com.croods.ecommerce.vo.TaxVo;

import lombok.Data;

@Data
public class SalesItemVo {

	private long salesItemId;
    SalesVo salesVo;
    String discountType;

    String discountTypeAdditional;
    private ProductVarientsVo productVarientsVo;
    private long productId;
    private float qty;
    private float returnqty;
    private String productDescription;
    private double price = 0.0;
    private double netAmount = 0.0;
    private double returnnetAmount = 0.0;
    private double mrp;
    private double taxAmount = 0.0;
    private double returntaxAmount = 0.0;
    private double taxRate = 0.0;
    private double cessAmount = 0.0;
    private double returncessAmount = 0.0;
    private double cessRate = 0.0;
    private TaxVo taxVo;
    private double discount = 0.0;
    private double discountAdditional = 0.0;
    private double mrpToDiscount = 0.0;
    String mrpToDiscountType;
    private double mrpTodiscountAdditional = 0.0;
    String mrpToDiscountTypeAdditional;
    private String designNo;
    private long salesmanId;
    private String batchNo;
    private String salesItemType;
    private String salesmanName;
    //private BarcodeVo barcodeVo;
    private double discount2 = 0.0;
    String discountType2;
    private float freeQty;
    private int isReturn;
    private String salesType;
    private double sellingPrice;
    private double landingCost;
    private double profit;
    private int orderBy;
   // private EmployeeVo salesMan;
    private Double availableQty;
    private String createdBy;
    private String quantity;
    private String oldData;
    private double totaldiscount;
    private double taxable;

}
