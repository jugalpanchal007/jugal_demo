package com.croods.ecommerce.vo;

import lombok.Data;

@Data
public class UserFrontVo {

	private long userFrontId;
	private String qrCodeNo;
	private long companyId;
	private String type;
	private String email;
	private String contactName;
	private String userName;
	private String phoneNo;
	private String cityCode;

	private String pincode;

	private String companyName;

	private String logoPrefix;

	private String logo;

	private String stateCode;

	private String countriesCode;

	private String year;

	// private String status;

}
