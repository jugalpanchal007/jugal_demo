package com.croods.ecommerce.dto.p2p;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class P2pStartRequestDto {

	private String appKey;
	private String username;
	private String amount;
	private String customerMobileNumber;
	private String externalRefNumber;
	private String externalrefnumber2;
	private String customeremail;
	private PushTodevice pushTodevice;

}
