package com.croods.ecommerce.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.config.ApiResponseRechargeHistoryDto;
import com.croods.ecommerce.config.ApiResponseRefundHistoryDto;
import com.croods.ecommerce.config.ApiResponseTransactionDto;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.dto.ContactAddressRequestDTO;
import com.croods.ecommerce.dto.RazorPayDto;
import com.croods.ecommerce.dto.RechargeDto;
import com.croods.ecommerce.dto.RefundDto;
import com.croods.ecommerce.dto.SalesPayload;
import com.croods.ecommerce.dto.SurveyFormDTO;
import com.croods.ecommerce.dto.UserSignUpDTO;
import com.croods.ecommerce.dto.VisitorSignUpDTO;
import com.croods.ecommerce.dto.cart.CartDTO;
import com.croods.ecommerce.dto.merchant.EcommerceMerchantDetailsDto;
import com.croods.ecommerce.dto.merchant.EcommerceMerchantFetchDetailsDto;
import com.croods.ecommerce.dto.p2p.P2pCheckStatusDto;
import com.croods.ecommerce.dto.product.AllProductsListRequestDTO;
import com.croods.ecommerce.dto.socialmedia.SocialMediaProjectionDto;
import com.croods.ecommerce.dto.wishlist.WishlistSaveDTO;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.socialmedia.SocialMediaService;
import com.croods.ecommerce.service.themecolor.EcommerceThemeColorsService;
import com.croods.ecommerce.service.userFront.UserFrontService;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.sales.SalesVo;
import com.croods.ecommerce.vo.themecolor.EcommerceThemeColorsVo;
import com.croods.ecommerce.vo.userfront.EcommerceUserfrontVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@Log
@Service
public class MainServiceImpl implements MainService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${base.url}")
	private String baseUrl;

	@Autowired
	APITokenService apiTokenService;

	@Autowired
	UserFrontService userFrontService;

	@Autowired
	SocialMediaService socialMediaService;

	@Autowired
	EcommerceThemeColorsService ecommerceThemeColorsService;

	@Override
	public ApiResponse findByUserByPhoneNo(String mobileNo, String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/user/isExisting?mobileNo=" + mobileNo);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("API_TOKEN", API_TOKEN);
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse findByUserName(String mobileNo, String password) {
		String URL = baseUrl
				.concat(Constant.API + "/user/checkpassword?mobileNo=" + mobileNo + "&password=" + password);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getproductsAndCategoriesList(long contactId, long branchId) {
		String URL = baseUrl
				.concat(Constant.API + "/productandcategory/list?contactId=" + contactId + "&branchId=" + branchId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getproductsByCategories(long catId, long contactId, long branchId) {
		String URL = baseUrl.concat(Constant.API + "/product/listbycategory?categoryId=" + catId + "&contactId="
				+ contactId + "&branchId=" + branchId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getCategoriesList() {
		String URL = baseUrl.concat(Constant.API + "/categories/list");
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getSalesListByContactId(long contactId) {
		String URL = baseUrl.concat(Constant.API + "/user/sales?contactId=" + contactId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getsalesDetailsBySalesId(long salesId, long branchId) {
		String URL = baseUrl.concat(Constant.API + "/user/sales/details?salesId=" + salesId + "&branchId=" + branchId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse findKey() {
		String URL = "http://" + baseUrl.concat(Constant.API + "/find/key");
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse findByUserByQrCode(String qrcode) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/get/visitor/" + qrcode);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse sendRecharge(String newUser, String firstName, String lastName, String phoneNo, String qrcode,
			String rechargeById, String rechargeToId, String rechargeAmount, String rechargeDescription,
			String rechargeType, String rechargeDeviceId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/recharge");
		ApiResponse apiResponse = new ApiResponse();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		RechargeDto dto = new RechargeDto(newUser, firstName, lastName, phoneNo, qrcode, rechargeToId, rechargeById,
				rechargeAmount, rechargeDescription, rechargeType, rechargeDeviceId);
		HttpEntity<RechargeDto> entity = new HttpEntity<>(dto, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return apiResponse;
	}

	@Override
	public ApiResponseRechargeHistoryDto getallrechargehistoryById(String rechargeById) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/get/rechargehistory/" + rechargeById);
		ApiResponseRechargeHistoryDto apiResponse = new ApiResponseRechargeHistoryDto();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		try {
			// apiResponse = restTemplate.getForObject(URL,
			// ApiResponseRechargeHistoryDto.class);
			ResponseEntity<ApiResponseRechargeHistoryDto> response = restTemplate.exchange(URL, HttpMethod.POST, entity,
					ApiResponseRechargeHistoryDto.class);
			System.err.println(response.getBody());
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return apiResponse;
		}

	}

	@Override
	public ApiResponse getrechargedetailsByRechargeById(String rechargeId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/get/rechargedetails/" + rechargeId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse checkrechargestatusByP2pId(String p2pId, String rechargeById, String rechargeToId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/checkrechargestatus");
		ApiResponse apiResponse = new ApiResponse();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		P2pCheckStatusDto p2pCheckStatusDto = new P2pCheckStatusDto(p2pId, rechargeById, rechargeToId);
		HttpEntity<P2pCheckStatusDto> entity = new HttpEntity<>(p2pCheckStatusDto, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
		} catch (Exception e) {

		}

		return apiResponse;
	}

	@Override
	public ApiResponse saveSales(SalesVo salesVo) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/sales/create");
		ApiResponse apiResponse = new ApiResponse();
		System.err.println(salesVo);
		HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<SalesVo> entity = new HttpEntity<SalesVo>(salesVo, headers);

		try {
			System.err.println("INSIDE SALES SAVE TRYBLOCK");
			System.err.println("URL--:" + URL);
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return apiResponse;
	}

	@Override
	public ApiResponse getsalesList(String userFrontId, String type) {
		String URL = "http://"
				+ baseUrl.concat(Constant.API + "/sales/list?userFrontId=" + userFrontId + "&type=" + type);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getSalesListByUserFrontId(String userFrontId, String type) {
		String URL = "http://"
				+ baseUrl.concat(Constant.API + "/sales/list/user?userFrontId=" + userFrontId + "&type=" + type);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getsalesDetailsBySalesId(String salesId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/sales/" + salesId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
			log.severe("" + apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse sendRefund(String newUser, String firstName, String lastName, String phoneNo, String qrcode,
			String refundById, String refundToId, String refundAmount, String refundDescription, String refundType,
			String salesId, String rechargeId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/refund");
		ApiResponse apiResponse = new ApiResponse();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		RefundDto dto = new RefundDto(newUser, firstName, lastName, phoneNo, qrcode, refundToId, refundById,
				refundAmount, refundType, refundDescription, salesId, rechargeId);

		HttpEntity<RefundDto> entity = new HttpEntity<>(dto, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return apiResponse;
	}

	@Override
	public ApiResponse sendRazorpay(RazorPayDto razorPayDto) {
		String URL = baseUrl.concat(Constant.API + "/payment/razorpay");
		ApiResponse apiResponse = new ApiResponse();
		System.err.println(razorPayDto);
		HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RazorPayDto> entity = new HttpEntity<RazorPayDto>(razorPayDto, headers);

		try {
			System.err.println("INSIDE RAZORPAY TRYBLOCK");
			System.err.println("URL--:" + URL);
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return apiResponse;
	}

	@Override
	public ApiResponse checkbyphoneNo(String userFrontId, String phoneNo) {
		String URL = "http://" + baseUrl
				.concat(Constant.API + "/checkexistingbyphone?userFrontId=" + userFrontId + "&phoneNo=" + phoneNo);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponseRefundHistoryDto getallrefundhistoryById(String refundById) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/get/refundhistory/" + refundById);
		ApiResponseRefundHistoryDto apiResponse = new ApiResponseRefundHistoryDto();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		try {
			ResponseEntity<ApiResponseRefundHistoryDto> response = restTemplate.exchange(URL, HttpMethod.POST, entity,
					ApiResponseRefundHistoryDto.class);
			System.err.println(response.getBody());
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return apiResponse;
		}
	}

	@Override
	public ApiResponse getrefunddetailsByRefundById(String refundId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/get/refunddetails/" + refundId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse checkMobNo(String mob) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/user/sendotp?&mobileNo=" + mob);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponseTransactionDto getTransactionByUserFrontId(String userFrontId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/transaction/list/" + userFrontId);
		ApiResponseTransactionDto apiResponse = new ApiResponseTransactionDto();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponseTransactionDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getRefundAmount(String userFrontId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/refundAmount/" + userFrontId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse checkIsAlreadyRefunded(String userFrontId) {
		String URL = "http://" + baseUrl.concat(Constant.API + "/checkIsAlreadyRefunded?userFrontId=" + userFrontId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
			log.info("RESPONSE-->" + apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse sendSignUpData(String newUser, String firstName, String lastName, String phoneNo,
			String qrcode) {

		String URL = "http://" + baseUrl.concat(Constant.API + "/visitor/signup/self");
		ApiResponse apiResponse = new ApiResponse();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		VisitorSignUpDTO dto = new VisitorSignUpDTO(newUser, firstName, lastName, phoneNo, qrcode);

		HttpEntity<VisitorSignUpDTO> entity = new HttpEntity<>(dto, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return apiResponse;

	}

	@Override
	public ApiResponse checkSalesPaymentCash(String userFrontId) {

		String URL = "http://" + baseUrl.concat(Constant.API + "/checkSalesPaymentCash?userFrontId=" + userFrontId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse getAllRechargeDevice() {

		String URL = "http://" + baseUrl.concat(Constant.API + "/get/all/recharge/device");
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse getVoucherDetailsByStallIdAndUserFrontIdAndVoucherMasterId(String stallId, String userFrontId,
			String voucherMasterId, String companyId, int isDeleted) {

		String URL = "http://" + baseUrl.concat(Constant.API + "/get/individualvocherdetails?userFrontId=" + userFrontId
				+ "&stallId=" + stallId + "&voucherMasterId=" + voucherMasterId + "&companyId=" + companyId
				+ "&isDeleted=" + isDeleted);

		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
			log.info("RESPONSE-->" + apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse checkItemWeekendPrice() {
		String URL = "http://" + baseUrl.concat(Constant.API + "/checkItemWeekendPrice");
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getUserAddressByContactId(long contactId) {
		String URL = baseUrl.concat(Constant.API + "/user/address?contactId=" + contactId);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse sendSalesPayload(SalesPayload salesPayload) {
		String URL = baseUrl.concat(Constant.API + "/savesales");
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<SalesPayload> entity = new HttpEntity<SalesPayload>(salesPayload, headers);

		try {
			System.err.println(salesPayload.toString());
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getWalletTransactionsByContactId(String contactId) {
		String URL = baseUrl.concat(Constant.API + "/uesr/wallet/transactions?userId=" + contactId);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse userSignUp(UserSignUpDTO userSignUpDTO) {
		String URL = baseUrl.concat(Constant.API + "/user/signup");
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserSignUpDTO> entity = new HttpEntity<UserSignUpDTO>(userSignUpDTO, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse updatePassword(UserSignUpDTO userSignUpDTO) {
		String URL = baseUrl.concat(Constant.API + "/user/updatePassword");
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserSignUpDTO> entity = new HttpEntity<UserSignUpDTO>(userSignUpDTO, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse sendOtpToMobileNo(String mobileNo) {
		String URL = baseUrl.concat(Constant.API + "/user/sendmessage?mobileNo=" + mobileNo);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse verifyOtpToMobileNo(String mobileNo, String otp) {
		String URL = baseUrl.concat(Constant.API + "/user/verifyotp?mobileNo=" + mobileNo + "&otp=" + otp);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getSurveyQuestions() {
		String URL = baseUrl.concat(Constant.API + "/survey/questions");
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse saveSurvey(SurveyFormDTO surveyFormDTO) {
		String URL = baseUrl.concat(Constant.API + "/survey/save");
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<SurveyFormDTO> entity = new HttpEntity<SurveyFormDTO>(surveyFormDTO, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse saveConatctAddress(ContactAddressRequestDTO contactAddressRequestDTO) {
		String URL = baseUrl.concat(Constant.API + "/user/address/save");
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<ContactAddressRequestDTO> entity = new HttpEntity<ContactAddressRequestDTO>(contactAddressRequestDTO,
				headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse deleteContactAddressByContactId(long contactAddressId) {
		String URL = baseUrl.concat(Constant.API + "/user/address/delete?contactAddressId=" + contactAddressId);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse updateContactProfile(UserSignUpDTO userSignUpDTO) {
		String URL = baseUrl.concat(Constant.API + "/user/update/profile");
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserSignUpDTO> entity = new HttpEntity<UserSignUpDTO>(userSignUpDTO, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getReferralCount(String contactId) {
		String URL = baseUrl.concat(Constant.API + "/user/getReferralCount?contactId=" + contactId);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getcashbackpercentage() {
		String URL = baseUrl.concat(Constant.API + "/getcashbackpercentage");
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getWalletBalance(long contactId) {
		String URL = baseUrl.concat(Constant.API + "/user/getWalletBalance?contactId=" + contactId);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getBestSellingItems() {
		String URL = baseUrl.concat(Constant.API + "/bestsellingitem?limit=12");
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse cancelSalesBySalesId(long salesId, long userId, long branchId) {

		String URL = baseUrl.concat(
				Constant.API + "/user/sales/cancel?salesId=" + salesId + "&userId=" + userId + "&branchId=" + branchId);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse getAllAdvertisements() {

		String URL = baseUrl.concat(Constant.API + "/user/offers");
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse userSaveWishList(WishlistSaveDTO wishlistSaveDTO) {

		String URL = baseUrl.concat(Constant.API + "/user/wishlist/save");
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<WishlistSaveDTO> entity = new HttpEntity<WishlistSaveDTO>(wishlistSaveDTO, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse userDeleteWishList(long wishlistId) {

		String URL = baseUrl.concat(Constant.API + "/user/wishlist/delete?wishlistId=" + wishlistId);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse getAllWishListProducts(long contId) {
		String URL = baseUrl.concat(Constant.API + "/user/wishlist/list?contactId=" + contId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse findByUserByoldpassword(String oldpassword, long contactid) {
		String URL = baseUrl
				.concat(Constant.API + "/checkoldpassword" + "/" + contactid + "?oldpassword=" + oldpassword);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse changePassword(String password, long contactId) {
		String URL = baseUrl.concat(Constant.API + "/changepassword" + "/" + contactId + "?pass=" + password);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse updatelatlng(long contId, String lat, String lng) {

		String URL = baseUrl.concat(Constant.API + "/updatelatlng?contactId=" + contId + "&lat=" + lat + "&lng=" + lng);
		System.err.println("URL : " + URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse saveOneSignalUserId(String userId) {
		String URL = baseUrl.concat(Constant.API + "/onesignal/save?userId=" + userId);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse deleteOneSignalUserId(String userId) {
		String URL = baseUrl.concat(Constant.API + "/onesignal/delete?userId=" + userId);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getBranchList(String lat, String lng) {
		String URL = baseUrl.concat(Constant.API + "/user/branch/list");
		System.err.println("URL : " + URL);

		String urlTemplate = UriComponentsBuilder.fromHttpUrl(URL).queryParam("lat", "{lat}").queryParam("lng", "{lng}")
				.encode().toUriString();
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lng", lng);

		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, ApiResponse.class, params)
					.getBody();
			log.severe("::: RESPONSE ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse findAllProductForJSON(long companyId) {
		String URL = baseUrl.concat(Constant.API + Constant.APIPRODUCTLIST + "?companyId=" + companyId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getIndividualProductJson(long contId, long actualbranchId, long productVarientId) {
		String URL = baseUrl.concat(Constant.API + "/product/json?productVarientId=" + productVarientId + "&contactId="
				+ contId + "&branchId=" + actualbranchId);
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getMinimumOnlineOrderAmount() {
		String URL = baseUrl.concat(Constant.API + "/minimumorderamount");
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse = restTemplate.getForObject(URL, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getCompantDetailsFromDomain(String domainName) {
		String URL = baseUrl.concat(Constant.API + Constant.COMPANY_DETAILS_BY_DOMAIN_URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("domainName", domainName);
		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonString = mapper.writeValueAsString(requestBody);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("JOSN STRING :: " + jsonString);
		HttpEntity<String> entity = new HttpEntity<String>(jsonString, headers);
		System.err.println("HELLOO HERE ::: 1");
		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getCompantDetailsFromDomain ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();

			System.err.println("HELLOO HERE ::: 2");
		}

		if (apiResponse.isStatus()) {
			if (apiResponse.getResponse() != null) {
				ObjectMapper objectMapper = new ObjectMapper();

				EcommerceMerchantFetchDetailsDto merchantDto = null;
				try {
					merchantDto = objectMapper.readValue(objectMapper.writeValueAsString(apiResponse.getResponse()),
							new TypeReference<EcommerceMerchantFetchDetailsDto>() {
							});
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				EcommerceMerchantDetailsDto ecommerceMerchantDetailsDto = new EcommerceMerchantDetailsDto();

				System.err.println("Merchant DTO ; " + merchantDto.getToken());
				if (merchantDto != null) {
					if (StringUtils.isNotBlank(merchantDto.getToken())) {

						APITokenVo apiTokenVo = apiTokenService.findByTokenAndIsDeleted(merchantDto.getToken(), 0);

						if (apiTokenVo != null) {

							ecommerceMerchantDetailsDto = returnEcommerceMerchantDetailsDto(
									apiTokenVo.getUserFrontId());
							ecommerceMerchantDetailsDto.setToken(apiTokenVo.getToken());
							ecommerceMerchantDetailsDto.setImageServer(merchantDto.getImageServer());
							ecommerceMerchantDetailsDto.setAlgoliaIndexName(merchantDto.getAlgoliaIndexName());
							ecommerceMerchantDetailsDto.setIsRazorPay(merchantDto.getIsRazorPay());
							ecommerceMerchantDetailsDto.setDecimalPoints(merchantDto.getDecimalPoints());
							ecommerceMerchantDetailsDto.setIsPaytm(merchantDto.getIsPaytm());
							ecommerceMerchantDetailsDto.setPaytmMID(merchantDto.paytmMID);
							ecommerceMerchantDetailsDto.setEnableWishlist(merchantDto.enableWishlist);
							try {
								ecommerceMerchantDetailsDto.setIsOrderConfirmationFlowEnabled(
										merchantDto.getIsOrderConfirmationFlowEnabled());
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								ecommerceMerchantDetailsDto.setIsOrderConfirmationFlowEnabled(0);
							}

							apiResponse = new ApiResponse(true, "Details Found...!!!", ecommerceMerchantDetailsDto);
						} else {
							apiResponse = new ApiResponse(false, "No Token Found in Ecommerce", null);
						}
					}
				} else {
					apiResponse = new ApiResponse(false, "No Response Found", null);
				}

			}

		} else {
			apiResponse = new ApiResponse(false, "Something went wrong", null);
		}

		return apiResponse;
	}

	@Override
	public ApiResponse getTopCategoriesForEcommerce(String companyId, String branchId) {
		String URL = baseUrl
				.concat(Constant.API + "/topcategorieslist?companyId=" + companyId + "&branchId=" + branchId);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesForEcommerce ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getBanners(String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + Constant.GET_BANNERS_URL);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(null, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getBanners ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getCountriesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse getstatesOfCountry(String countriesCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse getCategoriesList(String companyId, String branchId, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse getTopCategoriesList(String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + Constant.GET_TOP_CATEGORIES);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);

		Map<String, String> requestBody = new HashMap<>();

		requestBody.put("typeDate", "01/04/2021 - 31/12/2022");

		String data = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(requestBody);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("DATA ::: " + data);

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getTrendingProductsList(String companyId, String branchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse getBestSellingProductsList(String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + Constant.GET_BESTSELLING_PRODUCTS);
		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);

		Map<String, String> requestBody = new HashMap<>();

		requestBody.put("typeDate", "01/04/2022 - 31/03/2023");

		String data = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(requestBody);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("DATA ::: " + data);

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getAllProductsList(AllProductsListRequestDTO allProductsListRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse getProductDetails(String companyId, String branchId, String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse userEditProfile(UserSignUpDTO userSignUpDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse validateCart(List<CartDTO> cartList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse getCommonResponseForPostAPI(String API_TOKEN, Map<String, String> requestBody, String URL) {

		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);

		String data = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(requestBody);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("DATA ::: " + data);

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	@Override
	public ApiResponse getCommonResponseForGetApi(String API_TOKEN, Map<String, String> requestBody, String URL) {

		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);

		String data = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(requestBody);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("DATA ::: " + data);

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	public EcommerceMerchantDetailsDto returnEcommerceMerchantDetailsDto(long userFrontId) {

		EcommerceMerchantDetailsDto ecommerceMerchantDetailsDto = new EcommerceMerchantDetailsDto();

		EcommerceUserfrontVo userFrontVo = userFrontService.findByEcommerceUserfrontIdAndIsDeleted(userFrontId, 0);

//		List<SocialMediaVo> socialMediaVo = socialMediaService.findByUserFrontId(userFrontId);

		List<EcommerceThemeColorsVo> themeColorList = ecommerceThemeColorsService.findByUserfrontId(userFrontId);
		EcommerceThemeColorsVo ecommerceThemeColorsVo = null;

		List<SocialMediaProjectionDto> socialMediaVo = socialMediaService
				.getSocialMediaCutonListByUserFrontId(userFrontId);

		if (themeColorList.size() > 0) {
			ecommerceThemeColorsVo = themeColorList.get(0);
		}
		ecommerceMerchantDetailsDto.setLogo(userFrontVo.getLogo());
		ecommerceMerchantDetailsDto.setAddress(userFrontVo.getAddress());
		ecommerceMerchantDetailsDto.setAddress2(userFrontVo.getAddress2());
		ecommerceMerchantDetailsDto.setContactNo(userFrontVo.getTelephone());
		ecommerceMerchantDetailsDto.setEmail(userFrontVo.getEmail());

		ecommerceMerchantDetailsDto.setDescription(userFrontVo.getDescription());
		ecommerceMerchantDetailsDto.setAllowedGoogleLocationPlaces(userFrontVo.getAllowedGoogleLocationPlaces());
		ecommerceMerchantDetailsDto.setName(userFrontVo.getName());

		ecommerceMerchantDetailsDto.setUserFrontSocialMediaVos(socialMediaVo);
		ecommerceMerchantDetailsDto.setThemecolors(ecommerceThemeColorsVo);

		return ecommerceMerchantDetailsDto;
	}

	@Override
	public ApiResponse reorderBySalesIdforEcommerce(String salesId, String aPI_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		if (StringUtils.isNotBlank(salesId)) {
			try {

				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				headers.set(Constant.API_KEY, aPI_TOKEN);
				headers.setContentType(MediaType.APPLICATION_JSON);

				String data = "";
				ObjectMapper mapper = new ObjectMapper();

				HttpEntity<String> entity = new HttpEntity<String>(data, headers);

				String URL = baseUrl.concat(Constant.API + "/products/sales/reorder?salesId=" + salesId);
				try {
					apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
					log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());

				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {

		}

		return apiResponse;
	}

}
