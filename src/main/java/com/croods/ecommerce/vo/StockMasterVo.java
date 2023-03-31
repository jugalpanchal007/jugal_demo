package com.croods.ecommerce.vo;

import java.util.Date;

import lombok.Data;

@Data
public class StockMasterVo {

	private long stockId;

    private long branchId;

    private long companyId;

    private Date createdOn;

    private Date modified_on;

    private double Quantity;

    private ProductVarientsVo productVarientsVo;

    private String yearInterval;

    private String batchNo;

    private double mrp;

    private double purchasePrice;
}
