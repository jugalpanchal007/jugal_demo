package com.croods.ecommerce.dto;

import lombok.Data;

@Data
public class SalesDTO {
	
	private String url;
	
	private String salesNo;
	
	private double total;
	
	private double qty;
	
	private double price;
	
	private String name;
	
	private String varientName;
	
//	private List<SalesItemVo> salesItemVos;

}
