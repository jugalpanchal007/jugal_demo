package com.croods.ecommerce.vo;

import lombok.Data;

@Data
public class CategoryVo{
    public int categoryId;
    public String categoryName;
    public String categoryCode;
    public String categoryDescription;
    public int branchId;
    public int companyId;
    public int alterBy;
    public int createdBy;
    public int isDeleted;
    public int isDefault;
    public String createdOn;
    public Object modifiedOn;
    public int postion;
    public Object createdby_name;
}
