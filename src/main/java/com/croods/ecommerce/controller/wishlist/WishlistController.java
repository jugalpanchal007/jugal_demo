package com.croods.ecommerce.controller.wishlist;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.dto.wishlist.WishlistFetchFromErpDTO;
import com.croods.ecommerce.dto.wishlist.WishlistSaveDTO;
import com.croods.ecommerce.service.MainService;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.wishlist.WishlistService;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.wishlist.WishlistVo;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = { "*" })
public class WishlistController {

	@Autowired
	WishlistService wishlistService;

	@Autowired
	APITokenService apiTokenService;
	
	@Autowired
	MainService mainService;

	// GET WISHLIST
	@RequestMapping("/list")
	@ResponseBody
	public ApiResponse getWishlistbyContactId(@RequestParam(value = "contactId") String contactId, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {

		ApiResponse apiResponse = new ApiResponse(false, "FAILED", null);

		if (StringUtils.isNotBlank(API_TOKEN)) {

			APITokenVo apiTokenVo = apiTokenService.findByTokenAndIsDeleted(API_TOKEN, 0);

			if (apiTokenVo != null) {

//				List<Map<String, String>> list = null;
				List<WishlistVo> list = null;

				if (StringUtils.isNotBlank(contactId) && contactId != "undefined") {
					try {

						list = wishlistService.getWishlistByContactId(Long.parseLong(contactId));
//						list = wishlistService.getWishlistByContactId(Long.parseLong(contactId),API_TOKEN);

						if (list != null && list.size() > 0) {
							apiResponse = new ApiResponse(true, "Wishlist Found", list);
						} else {
							apiResponse = new ApiResponse(false, "No Records Found", list);
						}

					} catch (Exception e) {
						e.printStackTrace();
						apiResponse = new ApiResponse(false, "Something Went Wrong", e);
					}
				} else {
					apiResponse = new ApiResponse(false, "No Contact found", null);
				}

			} else {
				apiResponse = new ApiResponse(false, "No Token Found", null);
			}

		} else {
			apiResponse = new ApiResponse(false, "Invalid Token", null);
		}

		return apiResponse;

	}

	// SAVE WISHLIST

	@RequestMapping("/save")
	@ResponseBody
	public ApiResponse getWishlistbyContactId(@RequestBody WishlistSaveDTO wishlistSaveDTO, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {

		ApiResponse apiResponse = new ApiResponse(false, "FAILED", null);

		if (StringUtils.isNotBlank(API_TOKEN)) {

			APITokenVo apiTokenVo = apiTokenService.findByTokenAndIsDeleted(API_TOKEN, 0);

			if (apiTokenVo != null) {
				if (wishlistSaveDTO != null) {
					try {
						WishlistVo wishlistVo = wishlistService.saveProductIntoWishlist(wishlistSaveDTO,
								apiTokenVo.getUserFrontId(), apiTokenVo.getBranchId(), apiTokenVo.getCompanyId());
						apiResponse = new ApiResponse(true, "Successfully saved into wishlist", wishlistVo);
					} catch (Exception e) {
						e.printStackTrace();
						apiResponse = new ApiResponse(false, "Failed to save into wishlist", null);
					}

				} else {
					apiResponse = new ApiResponse(false, "No Data for Wishlist", null);
				}

			} else {
				apiResponse = new ApiResponse(false, "No Token Found", null);
			}

		} else {
			apiResponse = new ApiResponse(false, "Invalid Token", null);
		}

		return apiResponse;

	}

	// DELETE WISHLIST

	@RequestMapping("/delete")
	@ResponseBody
	public ApiResponse removeProductFromWishlist(@RequestParam(value = "wishllistId") String wishllistId,
			HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {

		ApiResponse apiResponse = new ApiResponse(false, "FAILED", null);

		if (StringUtils.isNotBlank(API_TOKEN)) {

			APITokenVo apiTokenVo = apiTokenService.findByTokenAndIsDeleted(API_TOKEN, 0);

			if (apiTokenVo != null) {

				if (StringUtils.isNotBlank(wishllistId)) {
					try {
						int result = wishlistService.removeProductFromWishlist(Long.parseLong(wishllistId));
						if (result > 0) {
							apiResponse = new ApiResponse(true, "Product Removed Successfully", result);
						} else {
							apiResponse = new ApiResponse(false, "No Action Done", result);
						}

					} catch (Exception e) {
						e.printStackTrace();
						apiResponse = new ApiResponse(false, "Something went wrong while removing", null);
					}
				} else {
					apiResponse = new ApiResponse(false, "No Wishlist Found", null);
				}

			} else {
				apiResponse = new ApiResponse(false, "No Token Found", null);
			}

		} else {
			apiResponse = new ApiResponse(false, "Invalid Token", null);
		}

		return apiResponse;

	}

	// GET WISHLIST
	@RequestMapping("/list/stock")
	@ResponseBody
	public ApiResponse getWishlistbyContactIdWithActualQty(@RequestParam(value = "contactId") String contactId,
			HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {

		ApiResponse apiResponse = new ApiResponse(false, "FAILED", null);

		if (StringUtils.isNotBlank(API_TOKEN)) {

			APITokenVo apiTokenVo = apiTokenService.findByTokenAndIsDeleted(API_TOKEN, 0);

			if (apiTokenVo != null) {
				
				List<WishlistFetchFromErpDTO> list = null;

				if (StringUtils.isNotBlank(contactId) && contactId != "undefined") {
					try {

						list = wishlistService.getWishlistFetchDtoForErp(Long.parseLong(contactId));
						
						if (list.size() > 0) {
							apiResponse = wishlistService.getWishlistForRealTimeStockFromErp(list,apiTokenVo.getToken());
						}else {
							apiResponse = new ApiResponse(false, "No List Found", null);
						}

					} catch (Exception e) {
						e.printStackTrace();
						apiResponse = new ApiResponse(false, "Something Went Wrong", e);
					}
				} else {
					apiResponse = new ApiResponse(false, "No Contact found", null);
				}

			} else {
				apiResponse = new ApiResponse(false, "No Token Found", null);
			}

		} else {
			apiResponse = new ApiResponse(false, "Invalid Token", null);
		}

		return apiResponse;

	}

}
