package com.croods.ecommerce.vo;

import java.util.List;

import lombok.Data;

@Data
public class ProductVarientsVo{
    public long productVarientId;
    public int shopifyVariantSourceId;
    public ProductVo productVo;
    public String varientName;
    public String inventoryPolicy;
    public Object sku;
    public double weight;
    public String position;
    public double purchasePrice;
    public double retailerPrice;
    public double wholesalerPrice;
    public double otherPrice;
    public double shopifyPrice;
    public double compareAtPrice;
    public double retailerMargin;
    public double wholesalerMargin;
    public double otherMargin;
    public double shopifyMargin;
    public String retailerMarginType;
    public String wholesalerMarginType;
    public String otherMarginType;
    public String shopifyMarginType;
    public double mrp;
    public double sellingPrice;
    public Object attributeValue1;
    public Object attributeValue2;
    public Object attributeValue3;
    public int isDeleted;
    public String itemCode;
    public double stockOfLimit;
    public int companyId;
    public int imageId;
    public int branchId;
    public double qty;
    public Object availableQty;
    public Object reserveQty;
    public double discount;
    public double discountAdditional;
    public Object discountType;
    public Object discountAdditionalType;
    public double inQty;
    public double outQty;
    public String status;
    public String batchNo;
    private List<StockMasterVo> stockMasterVos;
    private int allowNegativeStock;
    private DicountResponse dicountResponse;
}
