package com.croods.ecommerce.vo;

import lombok.Data;

@Data
public class BrandVo{
    public int brandId;
    public String brandName;
    public Object brandCode;
    public String brandDescription;
    public int isDefault;
   // public Object brandVo;
    public int branchId;
    public int companyId;
}
