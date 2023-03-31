package com.croods.ecommerce.constant;

import java.util.Arrays;
import java.util.List;

public class Constant {

	
	
	
	public static final String SELFCHECKOUTURL = "/selfcheckout";

	public static final String API = "/api/v1";
	public static final String API_KEY = "api-key";

	public static final String BEST_SELLING_API_URL = "/dashboard/bestselling";
	public static final String COMPANY_DETAILS_BY_DOMAIN_URL = "/companyDetails";

	public static final String GET_BANNERS_URL = "/getBanner";

	public static final String GET_TOP_CATEGORIES = "/dashboard/getbestcategory/ecommerce";
	public static final String GET_BESTSELLING_PRODUCTS = "/products/bestselling";

	public static final String CONTACT_CUSTOMER = "customers";

	public static final String SELFCHECKOUT = "self-checkout";

	public static final String PAYMENT_TYPE_PAYTM = "paytm";
	public static final String PAYMENT_TYPE_CASHFREE = "cashfree";
	public static final String PAYMENT_TYPE_RAZORPAY = "razorpay";
	public static final String PAYMENT_TYPE_INSTAMOJO = "instamojo";

	public static final String REFUND_TYPE_DIRECT = "direct";
	public static final String REFUND_TYPE_SALES = "onSales";
	public static final String REFUND_TYPE_SELF = "selfRefund";

	public static final String RECHARGE_TYPE_RECHARGE_POINT = "byRechargePoint";
	public static final String RECHARGE_TYPE_SELF = "self";
	public static final String RECHARGE_TYPE_CASH = "cash";

	public static final String REFUND_STATUS_PENDIND = "pending";
	public static final String REFUND_STATUS_APPROVED = "approved";
	public static final String REFUND_STATUS_REJECTED = "rejected";

	public static final String SALES_TYPE_SALES = "sales";
	public static final String SALES_TYPE_REFUND = "refund";

	public static final String SALES_PAYMENT_CASH = "salesPaymentCash";

	public static final String WALK_IN_CUSTOMER_QRCODE = "WALK_IN_CUSTOMER";

	public static final String STALL_TYPE_FOOD = "food";
	public static final String STALL_TYPE_MERCHANDISE = "merchandise";
	public static final String STALL_TYPE_ADVENTURE = "adventure";

	public static final String METHOD_COD = "cod";
	public static final String METHOD_RAZORPAY = "razorpay";
	public static final String METHOD_INSTAMOJO = "instamojo";
	public static final String METHOD_PAYTM = "paytm";

	public static final String CART_ADD_QUANTITY = "add";
	public static final String CART_MINUS_QUANTITY = "minus";

	public static final String APPSTATUS_ORDERPLACED = "orderplaced";// inprogress
	public static final String APPSTATUS_DISPATCHED = "dispatched";
	public static final String APPSTATUS_SHIPPED = "shipped";
	public static final String APPSTATUS_OUTFORDELIVERY = "outfordelivery";
	public static final String APPSTATUS_DELIVERED = "delivered";
	public static final String APPSTATUS_CALCELED = "canceled";

	public static final String APIPRODUCTLIST = "/productlist";

	/****** FILE VALIDATION CONSTANT START *********/
	public static final String FILE_IMAGE = "image";
	public static final String FILE_EXCEL = "excel";
	public static final String FILE_IMAGE_AND_PDF = "imagepdf";
	public static final String FILE_IMAGE_PDF_EXCEL_CSV = "imagepdfexcelcsv";

	public static final long MAX_FILE_SIZE_IMAGE = 10485760; // 10 MB
	public static final long MAX_FILE_SIZE_PDF_DOC_EXCEL = 10485760; // 10 MB
	public static final long MAX_FILE_SIZE_OTHER = 10485760; // 10 MB

	public static final List<String> VALID_FILE_TYPE_IMAGE = Arrays.asList("image/jpeg", "image/png", "image/bmp");
	public static final List<String> VALID_FILE_TYPE_IMAGE_PDF = Arrays.asList("image/jpeg", "image/png",
			"application/pdf");
	public static final List<String> VALID_FILE_TYPE_EXCEL = Arrays
			.asList("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	public static final List<String> VALID_FILE_TYPE_IMAGE_PDF_EXCEL_CSV = Arrays.asList("image/jpeg", "image/png",
			"application/pdf", "text/csv", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
			"application/vnd.ms-excel");
	/****** FILE VALIDATION CONSTANT END *********/

	public static final String FILE_UPLOAD_SERVER_S3 = "S3";
	public static final String FILE_UPLOAD_SERVER_AZURE = "AZURE";

	public static final List<String> CSV_INJECTION_CHARACTERS = Arrays.asList("9", "10", "11", "13", "43", "45", "60",
			"61", "62", "64");
	
	
	/****** CMS Pages Types *********/
	
	public static final String PRIVACY_POLICY = "privacyPolicy";
	public static final String RETURN_POLICY = "ReturnPolicy";
	public static final String TERMS_AND_CONDITION = "TermsAndCondition";
	public static final String REFUND_POLICY = "RefundPolicy";
	public static final String ABOUT_US = "AboutUs";
	public static final String CONTACT_US ="ContactUs";
	public static final String CANCELLATION_POLICY = "CancellationPoilcy"; 
	
	
   
	/*****Social-Media-Types******/
		public static final String FACEBOOK = "facebook";
	    public static final String INSTAGRAM = "instagram";
	    public static final String LINKEDIN = "linkedIn";
	    public static final String YOUTUBE = "youtube";
	    public static final String GMAIL = "gmail";
	    

}