package com.croods.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.config.ApiResponseRechargeHistoryDto;
import com.croods.ecommerce.config.ApiResponseRefundHistoryDto;
import com.croods.ecommerce.config.ApiResponseTransactionDto;
import com.croods.ecommerce.dto.ContactAddressRequestDTO;
import com.croods.ecommerce.dto.RazorPayDto;
import com.croods.ecommerce.dto.SalesPayload;
import com.croods.ecommerce.dto.SurveyFormDTO;
import com.croods.ecommerce.dto.UserSignUpDTO;
import com.croods.ecommerce.dto.cart.CartDTO;
import com.croods.ecommerce.dto.product.AllProductsListRequestDTO;
import com.croods.ecommerce.dto.wishlist.WishlistSaveDTO;
import com.croods.ecommerce.vo.sales.SalesVo;

public interface MainService {

	ApiResponse findByUserName(String username, String password);

	ApiResponse findByUserByQrCode(String qrcode);

	ApiResponse getCommonResponseForPostAPI(String API_TOKEN, Map<String, String> requestBody, String URL);

	ApiResponse findKey();

	ApiResponse checkSalesPaymentCash(String userFrontId);

	ApiResponse sendRecharge(String newUser, String firstName, String lastName, String phoneNo, String qrcode,
			String rechargeById, String rechargeToId, String rechargeAmount, String rechargeDescription,
			String rechargeType, String rechargeDeviceId);

	ApiResponse sendSignUpData(String newUser, String firstName, String lastName, String phoneNo, String qrcode);

	ApiResponse sendRefund(String newUser, String firstName, String lastName, String phoneNo, String qrcode,
			String refundById, String refundToId, String refundAmount, String refundDescription, String refundType,
			String salesId, String rechargeId);

	ApiResponseRechargeHistoryDto getallrechargehistoryById(String rechargeById);

	ApiResponse getrechargedetailsByRechargeById(String rechargeId);

	ApiResponse checkrechargestatusByP2pId(String p2pId, String rechargeById, String rechargeToId);

	ApiResponse getproductsAndCategoriesList(long contactId, long branchId);

	ApiResponse saveSales(SalesVo salesVo);

	ApiResponse getsalesList(String userFrontId, String type);

	ApiResponse getSalesListByUserFrontId(String userFrontId, String type);

	ApiResponse getsalesDetailsBySalesId(String salesId);

	ApiResponse sendRazorpay(RazorPayDto razorPayDto);

	ApiResponse checkbyphoneNo(String userFrontId, String phoneNo);

	ApiResponseRefundHistoryDto getallrefundhistoryById(String refundById);

	ApiResponse getrefunddetailsByRefundById(String refundId);

	ApiResponse checkMobNo(String mob);

	ApiResponse findByUserByPhoneNo(String phoneNo, String API_TOKEN);

	ApiResponseTransactionDto getTransactionByUserFrontId(String userFrontId);

	ApiResponse getRefundAmount(String userFrontId);

	ApiResponse checkIsAlreadyRefunded(String userFrontId);

	ApiResponse getAllRechargeDevice();

	ApiResponse getVoucherDetailsByStallIdAndUserFrontIdAndVoucherMasterId(String stallId, String userFrontId,
			String voucherMasterId, String companyId, int i);

	ApiResponse checkItemWeekendPrice();

	ApiResponse getproductsByCategories(long catId, long contId, long branchId);

	ApiResponse getCategoriesList();

	ApiResponse getUserAddressByContactId(long contactId);

	ApiResponse sendSalesPayload(SalesPayload salesPayload);

	ApiResponse getWalletTransactionsByContactId(String contactId);

	ApiResponse userSignUp(UserSignUpDTO userSignUpDTO);

	ApiResponse updatePassword(UserSignUpDTO userSignUpDTO);

	ApiResponse sendOtpToMobileNo(String mobileNo);

	ApiResponse verifyOtpToMobileNo(String mobileNo, String otp);

	ApiResponse getSurveyQuestions();

	ApiResponse saveSurvey(SurveyFormDTO surveyFormDTO);

	ApiResponse saveConatctAddress(ContactAddressRequestDTO contactAddressRequestDTO);

	ApiResponse getSalesListByContactId(long contactId);

	ApiResponse getsalesDetailsBySalesId(long salesId, long branchId);

	ApiResponse deleteContactAddressByContactId(long contactAddressId);

	ApiResponse updateContactProfile(UserSignUpDTO userSignUpDTO);

	ApiResponse getReferralCount(String contactId);

	ApiResponse getcashbackpercentage();

	ApiResponse getWalletBalance(long contactId);

	ApiResponse getBestSellingItems();

	ApiResponse cancelSalesBySalesId(long salesId, long userId, long branchId);

	ApiResponse getAllAdvertisements();

	ApiResponse userSaveWishList(WishlistSaveDTO wishlistSaveDTO);

	ApiResponse userDeleteWishList(long wishlistId);

	ApiResponse getAllWishListProducts(long contId);

	ApiResponse findByUserByoldpassword(String oldpassword, long contactId);

	ApiResponse changePassword(String password, long contactId);

	ApiResponse updatelatlng(long contId, String lat, String lng);

	ApiResponse saveOneSignalUserId(String userId);

	ApiResponse deleteOneSignalUserId(String userId);

	ApiResponse getBranchList(String lat, String lng);

	ApiResponse findAllProductForJSON(long companyId);

	ApiResponse getIndividualProductJson(long contId, long actualbranchId, long productVarientId);

	ApiResponse getMinimumOnlineOrderAmount();

	ApiResponse getCompantDetailsFromDomain(String domainName);

	ApiResponse getTopCategoriesForEcommerce(String companyId, String branchId);

	ApiResponse getBanners(String API_TOKEN);

	ApiResponse getCountriesList();

	ApiResponse getstatesOfCountry(String countriesCode);

	ApiResponse getCategoriesList(String companyId, String branchId, int limit);

	ApiResponse getTopCategoriesList(String API_TOKEN);

	ApiResponse getTrendingProductsList(String companyId, String branchId);

	ApiResponse getBestSellingProductsList(String API_TOKEN);

	ApiResponse getAllProductsList(AllProductsListRequestDTO allProductsListRequestDTO);

	ApiResponse getProductDetails(String companyId, String branchId, String productId);

	ApiResponse userEditProfile(UserSignUpDTO userSignUpDTO);

	ApiResponse validateCart(List<CartDTO> cartList);

	ApiResponse getCommonResponseForGetApi(String API_TOKEN, Map<String, String> requestBody, String URL);

	ApiResponse reorderBySalesIdforEcommerce(String salesId, String aPI_TOKEN);

}
