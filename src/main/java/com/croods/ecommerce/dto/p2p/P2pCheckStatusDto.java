package com.croods.ecommerce.dto.p2p;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class P2pCheckStatusDto {

	private String p2pId;
	private String rechargeById;
	private String rechargeToId;
}
