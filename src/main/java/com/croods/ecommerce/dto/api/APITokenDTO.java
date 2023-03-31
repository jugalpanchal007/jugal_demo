package com.croods.ecommerce.dto.api;

import lombok.Data;

@Data
public class APITokenDTO {

	private long userFrontId;
	private String token;
	private int status;
	private long companyId;
	private long branchId;
	private int isDeleted;
	private String allowedIpAddresses;
}
