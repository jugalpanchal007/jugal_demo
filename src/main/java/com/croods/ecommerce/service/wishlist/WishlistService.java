package com.croods.ecommerce.service.wishlist;

import java.util.List;
import java.util.Map;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.dto.wishlist.WishlistFetchFromErpDTO;
import com.croods.ecommerce.dto.wishlist.WishlistSaveDTO;
import com.croods.ecommerce.vo.wishlist.WishlistVo;

public interface WishlistService {

//	Save Wishlist with DTO
	public WishlistVo saveProductIntoWishlist(WishlistSaveDTO wishlistSaveDTO, long userFrontId, long branchId,
			long companyId);

//	Delete Wishlist by Id
	public int removeProductFromWishlist(long wishlistId);

//	get Wishlist 
//	public List<Map<String, String>> getWishlistByContactId(long contactId, String API_TOKEN);
	public List<WishlistVo> getWishlistByContactId(long contactId);
	
	List<WishlistFetchFromErpDTO> getWishlistFetchDtoForErp(long contactId);

	public ApiResponse getWishlistForRealTimeStockFromErp(List<WishlistFetchFromErpDTO> list,String API_TOKEN);
}
