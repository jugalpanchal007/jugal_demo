package com.croods.ecommerce.repo.userfront;

import org.springframework.data.jpa.repository.JpaRepository;

import com.croods.ecommerce.vo.userfront.EcommerceUserfrontVo;

public interface UserFrontRepo extends JpaRepository<EcommerceUserfrontVo, Long> {

	EcommerceUserfrontVo findByEcommerceUserfrontIdAndIsDeleted(long commerceUserfrontId, int isDeleted);

}
