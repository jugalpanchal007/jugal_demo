package com.croods.ecommerce.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.dto.ContactAddressRequestDTO;
import com.croods.ecommerce.dto.SalesPayload;
import com.croods.ecommerce.dto.UserSignUpDTO;
import com.croods.ecommerce.dto.cart.StockVerificationReuestDto;
import com.croods.ecommerce.service.MainService;
import com.croods.ecommerce.service.EcommerceAdmin.EcommerceAdminService;
import com.croods.ecommerce.service.EcommerceAdmin.EcommerceAdminServiceImpl;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.vo.EcommerceAdmin.EcommerceAdminVo;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@Log
@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = { "http://localhost:3000/", "https://shop.vasyerp.com:8443/", "https://shop.vasyerp.com/", "*" })
public class MainController {

	@Autowired
	MainService mainService;

	@Value("${base.url}")
	private String baseUrl;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EcommerceAdminService ecommerceAdminService;
	
	@Autowired
	APITokenService apiTokenService;
	
	@Autowired
	EcommerceAdminServiceImpl ecommerceAdminServiceImpl;
	//////////////////// NEW CODE START ///////////////////////

	// 1.0 Login Module
	// 1.1 Check Domain and get merchant Details
	// 1.2 Check Existing Mobile No
	// 1.3 Send OTP Mobile No
	// 1.4 Verify OTP and get contact/customer Details

	// 2.0 Location Module Apis
	// 2.1 Country List
	// 2.2 State List of a particular country
	// 2.3 City LIst of a particular state

	// 3.0 Categories Module Apis
	// 3.1 Top Categories List (max 10 Categories)
	// 3.2 List of Categories with its sub categories. (with limit)

	// 4.0 Products Module APIS
	// 4.1 Best Selling Products List (max 10 Products)
	// 4.2 Trending Products List (max 10 Products)
	// 4.3 List of Products with its variation count
	// 4.4 Product Details with its Variations Details

	// 5.0 Customer Module Apis
	// 5.1 Create A Customer by basic details
	// 5.2 Edit customer details
	// 5.3 Customer Address Apis
	// 5.3.1 Add new Address with its lat-lng
	// 5.3.2 Edit its Address
	// 5.3.3 Delete its Address

	// 6.0 Checkout /Place Order/Save Sale
	// 6.1 Check Available Quantity Api
	// 6.2 Save Sales Api

	// 7.0 Order Apis
	// 7.1 Order List of a logged Api
	// 7.2 Order Details Api
	// 7.3 Cancel Order Api.

	//////////////////// NEW CODE ENDS ///////////////////////

	// 1.0 Login Module

	// 1.1 Check Domain and get merchant Details
	@RequestMapping("/company/{domainName}")
	public ApiResponse getCompantDetailsFromDomain(HttpSession session, @PathVariable("domainName") String domainName) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getCompantDetailsFromDomain(domainName);
		log.severe("....." + apiResponse);

		return apiResponse;
	}

	// 1.2 Check Existing Mobile No
	@RequestMapping("/user/{mobileNo}")
	public ApiResponse getuserbyphoneNo(@PathVariable(value = "mobileNo") String mobileNo,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.findByUserByPhoneNo(mobileNo, API_TOKEN);
		if (apiResponse.isStatus()) {
			log.info("RESPONSE getuserbyphoneNo ::::: " + apiResponse);
		} else {
			log.severe("ELSE RESPONSE :" + apiResponse.isStatus());
		}
		return apiResponse;
	}

	// 1.3 Send OTP Mobile No
	@RequestMapping("/user/otp/send/{mobileNo}")
	@ResponseBody
	public ApiResponse sendOtp(@PathVariable(value = "mobileNo") String mobileNo, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/user/sendmessage");
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("mobileNumber", mobileNo);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	// 1.4 Verify OTP and get contact/customer Details
	@RequestMapping("/user/otp/verify")
	@ResponseBody
	public ApiResponse verifyOtp(@RequestParam(value = "mobileNo") String mobileNo,
			@RequestParam(value = "otp") String otp, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/user/verifyotp");
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("mobileNumber", mobileNo);
		requestBody.put("otp", otp);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@RequestMapping("/users")
	@ResponseBody
	public ApiResponse verifyCustomer(@RequestParam(value = "mobileNo") String mobileNo, HttpSession session,

			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/user/isExisting?mobileNo=" + mobileNo);
		Map<String, String> requestBody = new HashMap<>();
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@PostMapping("/users/signup")
	@ResponseBody
	public ApiResponse signup(@RequestBody UserSignUpDTO userSignUpDTO, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/user/signup");
		Map<String, String> requestBody = new HashMap<>();
		ApiResponse apiResponse = new ApiResponse();
//		requestBody.put("name", userSignUpDTO.getContactFirstName() + userSignUpDTO.getContactLastName());
		requestBody.put("firstname", userSignUpDTO.getContactFirstName());
		requestBody.put("lastname", userSignUpDTO.getContactLastName());
		requestBody.put("phoneno", userSignUpDTO.getContactNo());
		requestBody.put("email", userSignUpDTO.getEmail());
		requestBody.put("country", userSignUpDTO.getCountry());
		requestBody.put("state", userSignUpDTO.getState());
		requestBody.put("city", userSignUpDTO.getCity());
		requestBody.put("pincode", userSignUpDTO.getPincode());
		if (StringUtils.isNotBlank(userSignUpDTO.getContactId())) {
			requestBody.put("contactId", userSignUpDTO.getContactId());
		}

		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	// 2.0 Location Module Apis
	// 2.1 Country List
	@RequestMapping("/locality/countries")
	@ResponseBody
	public ApiResponse getCountriesList(@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/location/country");
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	// 2.2 State List of a particular country
	@RequestMapping("/locality/state/{countriesCode}")
	@ResponseBody
	public ApiResponse getStateList(@PathVariable(value = "countriesCode") String countriesCode, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/location/state/" + countriesCode);
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	// 2.3 City LIst of a particular state
	@RequestMapping("/locality/city/{stateCode}")
	@ResponseBody
	public ApiResponse getCityList(@PathVariable(value = "stateCode") String stateCode, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/location/city/" + stateCode);
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	// 3.0 Categories Module Apis
	// 3.1 Top Categories List (max 10 Categories)
	@RequestMapping("/categories/topcategories")
	@ResponseBody
	public ApiResponse gettopcategoriesList(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getTopCategoriesList(API_TOKEN);
		log.severe("....." + apiResponse);
		return apiResponse;
	}

	// 3.2 List of Categories with its sub categories. (with limit)
	@RequestMapping("/categories")
	@ResponseBody
	public ApiResponse getCategoriesList(HttpSession session, @RequestParam(value = "page") String page,
			@RequestParam(value = "length") String length, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/category/getCategory?page=" + page + "&length=" + length);
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	// 4.0 Products Module APIS
	// 4.1 Best Selling Products List (max 10 Products)
	@RequestMapping("/products/bestselling")
	@ResponseBody
	public ApiResponse getBestSellingProductsList(HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getBestSellingProductsList(API_TOKEN);
		log.severe("....." + apiResponse);
		return apiResponse;
	}

	// 4.2 Trending Products List (max 10 Products)
	@RequestMapping("/products/trending")
	@ResponseBody
	public ApiResponse getTrendingProductsList(HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/products/getTraindingProduct");
		Map<String, String> requestBody = new HashMap<>();
		ApiResponse apiResponse = new ApiResponse();
		requestBody.put("interval", "2021-2022");

		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;

	}

	// 4.3 List of Products with its variation count
	@GetMapping("/products")
	public ApiResponse getAllProductsList(HttpSession session, @RequestParam(value = "page") String page,
			@RequestParam(value = "length") String length,
			@RequestParam(value = "categorys", required = false) String categorys,
			@RequestParam(value = "brands", required = false) String brands,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "minprice", required = false) String minprice,
			@RequestParam(value = "maxprice", required = false) String maxprice,
			@RequestParam(value = "inclueoutofstock", required = false) String inclueoutofstock) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		// requestBody.put("strDate", "01/04/2021");
		// requestBody.put("endDate", "30/08/2022");
		if (categorys != null && !categorys.trim().isEmpty()) {

			requestBody.put("categorys", categorys);
		}
		if (brands != null && !brands.trim().isEmpty()) {
			requestBody.put("brands", brands);
		}

		if (order != null && !order.trim().isEmpty()) {
			requestBody.put("order", order);
		} else {
			requestBody.put("order", "releveant");
		}

		if (minprice != null && !minprice.trim().isEmpty()) {
			requestBody.put("minprice", minprice);
		}
		if (maxprice != null && !maxprice.trim().isEmpty()) {
			requestBody.put("maxprice", maxprice);
		}
		if (StringUtils.isNotBlank(inclueoutofstock)) {
			System.err.println("kfjuhgdf");
			requestBody.put("inclueoutofstock", inclueoutofstock);
		}
		System.err.println("requestBody :: " + requestBody);
		String URL = baseUrl.concat(Constant.API + "/products/ecommerce/list?page=" + page + "&length=" + length);
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);

		return apiResponse;
	}

	// 5.2 Edit customer details
	@PutMapping("/user/{id}")
	@ResponseBody
	public ApiResponse userEditProfile(@PathVariable("id") String contactId, HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/user/" + contactId);
		Map<String, String> requestBody = new HashMap<>();
		ApiResponse apiResponse = new ApiResponse();

		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;

	}

	// 5.3 Customer Address Apis
	@GetMapping("/user/address")
	@ResponseBody
	public ApiResponse getUserAddress(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("contactId") String contactIdString, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();

		String URL = baseUrl.concat(Constant.API + "/user/customerAddress/" + contactIdString);
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	// 5.3.1 Add new Address with its lat-lng
	// 5.3.2 Edit its Address
	@PostMapping("/user/address")
	@ResponseBody
	public ApiResponse saveConatctAddress(@RequestBody ContactAddressRequestDTO contactAddressRequestDTO,
			HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@RequestParam("contactId") String contactId) {
		String URL = baseUrl.concat(Constant.API + "/user/createAddress/" + contactId);
		Map<String, String> requestBody = new HashMap<>();
		ApiResponse apiResponse = new ApiResponse();

		String contactAddressId = "0";
		if (StringUtils.isNotBlank(contactAddressRequestDTO.getContactAddressId())) {
			contactAddressId = contactAddressRequestDTO.getContactAddressId();
		}
		requestBody.put("contactAddressId", contactAddressId);
		requestBody.put("nameTitle", contactAddressRequestDTO.getNameTitle());
		requestBody.put("addressLine1", contactAddressRequestDTO.getAddressLine1());
		requestBody.put("addressLine2", contactAddressRequestDTO.getAddressLine2());
		requestBody.put("addressType", contactAddressRequestDTO.getAddressType());
		requestBody.put("firstName", contactAddressRequestDTO.getFirstName());
		requestBody.put("lastName", contactAddressRequestDTO.getLastName());

		requestBody.put("cityCode", contactAddressRequestDTO.getCityCode());
		requestBody.put("contactId", contactAddressRequestDTO.getContactId());
		requestBody.put("countriesCode", String.valueOf(contactAddressRequestDTO.getCountriesCode()));
		requestBody.put("name",
				String.valueOf(contactAddressRequestDTO.getFirstName() + contactAddressRequestDTO.getLastName()));
		requestBody.put("lat", String.valueOf(contactAddressRequestDTO.getLat()));
		requestBody.put("lng", String.valueOf(contactAddressRequestDTO.getLng()));
		requestBody.put("nameTitle", String.valueOf(contactAddressRequestDTO.getNameTitle()));
		requestBody.put("pinCode", String.valueOf(contactAddressRequestDTO.getPinCode()));
		requestBody.put("place", String.valueOf(contactAddressRequestDTO.getPlace()));
		requestBody.put("stateCode", String.valueOf(contactAddressRequestDTO.getStateCode()));
		requestBody.put("landMark", contactAddressRequestDTO.getLandMark());
		requestBody.put("alternateMobileNumber", contactAddressRequestDTO.getAlternateMobileNumber());
		requestBody.put("phoneNo", contactAddressRequestDTO.getPhoneNo());
		requestBody.put("isDefault", String.valueOf(contactAddressRequestDTO.getIsDefault()));
		System.out.println(contactAddressRequestDTO.getPinCode() + "================================Pin");
		/*
		 * requestBody.put("lat", String.valueOf(contactAddressRequestDTO.getLat()));
		 * requestBody.put("lag", String.valueOf(contactAddressRequestDTO.getLng()));
		 * requestBody.put("lag", String.valueOf(contactAddressRequestDTO.getLng()));
		 * requestBody.put("place", contactAddressRequestDTO.getPlace());
		 * requestBody.put("cityCode", contactAddressRequestDTO.getCityCode());
		 * requestBody.put("stateCode", contactAddressRequestDTO.getStateCode());
		 * requestBody.put("countriesCode",
		 * contactAddressRequestDTO.getCountriesCode());
		 * 
		 */
//		if (contactAddressRequestDTO.getContactAddressId() != 0) {
//			requestBody.put("contactAddressId", String.valueOf(contactAddressRequestDTO.getContactAddressId()));
//		}

		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;

	}

	// 5.3.3 Delete its Address
	@DeleteMapping("/user/address/{contactAddressId}")
	@ResponseBody
	public ApiResponse userDeleteAddress(@PathVariable("contactAddressId") long contactAddressId,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/user/delete/address/" + contactAddressId);
		Map<String, String> requestBody = new HashMap<>();
		ApiResponse apiResponse = new ApiResponse();

		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;

	}

	// 6.0 Checkout /Place Order/Save Sale
	// 6.2 Save Sales Api
	@PostMapping("/orders")
	@ResponseBody
	public ApiResponse saveSales(HttpSession session, @RequestBody SalesPayload salesPayload,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {

		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);

		String data = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(salesPayload);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("DATA saveSales ::: " + data);

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);
		String URL = baseUrl.concat(Constant.API + "/stock/savesales/");
		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	// 6.1 Check Available Quantity Api/Validate Cart
	@RequestMapping("orders/validateCart")
	@ResponseBody
	public ApiResponse validateCart(HttpSession session, @RequestBody StockVerificationReuestDto cartList,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {

		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);

		String data = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(cartList);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("DATA ::: " + data);

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);
		String URL = baseUrl.concat(Constant.API + "/stock/stockverification/");
		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;

	}

	// 7.0 Order Apis
	// 7.1 Order List of a logged Api
	@GetMapping("user/sales")
	@ResponseBody
	public ApiResponse getSalesListByContactId(@RequestParam(value = "userId") long contactId, HttpSession session) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getSalesListByContactId(contactId);
		return apiResponse;

	}

	// 7.2 Order Details Api
	@GetMapping("/user/sales/{salesId}")
	@ResponseBody
	public ApiResponse getSalesDetailsBySalesId(@PathVariable(value = "salesId") long salesId,
			@RequestParam(value = "branchId") long branchId, HttpSession session) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getsalesDetailsBySalesId(salesId, branchId);
		return apiResponse;

	}

	@GetMapping("/banners")
	public ApiResponse getBanners(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/getBanner");
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@GetMapping("/brands")
	@ResponseBody
	public ApiResponse getBrand(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@RequestParam("page") String page, @RequestParam("length") String length) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/brands/getBrand?page=" + page + "&length=" + length);
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@GetMapping("/sales/{salesId}")
	@ResponseBody

	public ApiResponse getSaleshDetailsBySaleshId(HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN, @PathVariable("salesId") String salesId) {

		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/products/sales/details?salesId=" + salesId);
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;

	}

	@GetMapping("/sales/customers/{id}")
	@ResponseBody
	public ApiResponse getSaleshDetailsByCustomer(HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN, @PathVariable("id") String id) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/products/sales/detailsbyCutomer?customerId=" + id);
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@RequestMapping("/products/{id}")
	@ResponseBody
	public ApiResponse getProductDetailsById(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@PathVariable("id") String id) {
		log.info("HELLLLLLLLLLLLLLLLLLLLLLLOOOO : " + id);
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		if (StringUtils.isNotBlank(id) || (!id.equalsIgnoreCase("undefined"))) {

			String URL = baseUrl.concat(Constant.API + "/products/getProductVarient/" + id);
			apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);

		} else {
			return new ApiResponse(false, "Id is not defined", null);
		}

		return apiResponse;

	}

	@RequestMapping("/users/{id}")
	@ResponseBody
	public ApiResponse getCustomerDetails(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@PathVariable("id") String id) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/user/" + id);
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@PutMapping("/orders/{id}")
	@ResponseBody
	public ApiResponse cancelOrder(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@PathVariable("id") String id) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/products/user/sales/cancel/" + id);
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@GetMapping("/admins")
	@ResponseBody
	public ApiResponse getAllAdminSetting(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		String URL = baseUrl.concat(Constant.API + "/user/getEcommerceAdminDetails");
		apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@PostMapping("/admins")
	@ResponseBody
	public ApiResponse setAllAdminSetting(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			HttpServletRequest request, HttpServletResponse response, @RequestParam("value") String value,
			@RequestParam("type") String type) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("value", value);
		requestBody.put("type", type);
		String URL = baseUrl.concat(Constant.API + "/user/setAdminSettings");
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@PostMapping("/admins/default")
	@ResponseBody
	public ApiResponse setDefaultSetting(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			HttpServletRequest request) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();

		String URL = baseUrl.concat(Constant.API + "/user/setEcommerceAdmin/default");
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@PostMapping("/ecommerce/merchant/order/trackingtrail/{id}")
	@ResponseBody
	public ApiResponse getListOnlineOrderStatus(HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN, HttpServletRequest request,
			@PathVariable("id") String id) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();

		String URL = baseUrl.concat(Constant.API + "/ecommerce/merchant/order/trackingtrail/" + id);
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@PostMapping("/brandsbycategory")
	@ResponseBody
	public ApiResponse getBrandsbycategory(HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN,
			@RequestParam String categorys) {

		ApiResponse apiResponse = new ApiResponse();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);

		System.err.println("DATA getBrandByCaregory ::: " + categorys);

		HttpEntity<String> entity = new HttpEntity<String>(categorys, headers);
		String URL = baseUrl.concat(Constant.API + "/brands/getBrandByCaregory?categorys=" + categorys);

		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	@RequestMapping("/paytm/generatetxntoken")
	@ResponseBody
	public ApiResponse generateTxnTokenOfPaytm(@RequestParam(value = "amount") String amount, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/ecommerce/paytm/generatetxntoken");
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("amount", amount);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@RequestMapping("/paytm/order/status")
	@ResponseBody
	public ApiResponse getPaymentStatusForPaytmEcommerce(@RequestParam(value = "orderid") String orderid,
			HttpSession session, @RequestHeader(value = "API_TOKEN") String API_TOKEN) {
		String URL = baseUrl.concat(Constant.API + "/ecommerce/paytm/order/status");
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("orderid", orderid);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse = mainService.getCommonResponseForPostAPI(API_TOKEN, requestBody, URL);
		return apiResponse;
	}

	@RequestMapping("/product/availableQty/{id}")
	@ResponseBody
	public ApiResponse getStockValueByProductVarientIdAndBranchIdForEcommerce(HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN, @PathVariable("id") String id) {
		log.info("HELLLLLLLLLLLLLLLLLLLLLLLOOOO : " + id);
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> requestBody = new HashMap<>();
		if (StringUtils.isNotBlank(id) || (!id.equalsIgnoreCase("undefined"))) {

			String URL = baseUrl.concat(Constant.API + "/products/availableQty/" + id);
			apiResponse = mainService.getCommonResponseForGetApi(API_TOKEN, requestBody, URL);

		} else {
			return new ApiResponse(false, "Id is not defined", null);
		}

		return apiResponse;

	}

	@RequestMapping("/reorder")
	@ResponseBody
	public ApiResponse getWishlistbyContactId(@RequestParam(value = "salesId") String salesId, HttpSession session,
			@RequestHeader(value = "API_TOKEN") String API_TOKEN) {

		ApiResponse apiResponse = new ApiResponse(false, "FAILED", null);

		if (StringUtils.isNotBlank(API_TOKEN)) {

			APITokenVo apiTokenVo = apiTokenService.findByTokenAndIsDeleted(API_TOKEN, 0); 

			if (apiTokenVo != null) {

				if (StringUtils.isNotBlank(salesId) && salesId != "undefined") {
					try {

						apiResponse = mainService.reorderBySalesIdforEcommerce(salesId, API_TOKEN);

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
	
	


//	@GetMapping("/api/bestseller")
//	public ApiResponse getBestseller(@RequestHeader(value = "API_TOKEN") String API_TOKEN,
//			@RequestParam String settingsType) {
//		APITokenVo apiToken = apiTokenService.findByToken(token);
//		if (apiToken == null || apiToken.getStatus() == 0) {
//			return new ApiResponse(false, "No Token Found", null);
//		} else {
////			Map<String, Object> response = new HashMap<>();
////			response.put("branch_id", apiToken.getBranchId());
////			response.put("user_id", apiToken.getUserFrontId());
////			response.put("company_id", apiToken.getCompanyId());
//			
//			//Check Settings exists or not
//			EcommerceAdminVo is not null
//			
//			//If Exists update respoective record by its id
//			//if not create a new record
//			
//			return new ApiResponse(true, "Settings Found", null);
//		}
//
//	}
}
