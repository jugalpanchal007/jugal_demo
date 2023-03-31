
package com.croods.ecommerce.service.userFront;

import com.croods.ecommerce.dto.merchant.MerchantDTO;
import com.croods.ecommerce.vo.userfront.EcommerceUserfrontVo;

public interface UserFrontService {

	EcommerceUserfrontVo save(MerchantDTO merchantDTO);

	EcommerceUserfrontVo findByEcommerceUserfrontIdAndIsDeleted(long commerceUserfrontId, int isDeleted);
}
