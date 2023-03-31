package com.croods.ecommerce.vo.sales;

import java.util.Date;
import java.util.List;

import com.croods.ecommerce.vo.UserFrontVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesVo {

	String termsAndConditionIds;
	String note;
	private long salesId;
	private long salesNo;
	private String prefix;
	private Date salesDate;
	private Date dueDate;
	private Date DeliveredDate;
	private int sez;
//	private PaymentTermVo paymentTermsVo;
	private SalesVo salesVo;
//	private DiscountVo discountVo;
//	private DiscountVo discountVoFlat;
//	private ContactVo contactVo;
//	private ContactVo contactVos;
	private long customerId;
	private double creditAmount;
	private long companyId;
	private long branchId;
	private long alterBy;
	private String creditNoteId;

	private double tendered;

	private long createdBy;

	private int isDeleted;

	private int paymentReminder;

	private String createdOn;

	private String modifiedOn;

	private String type;

	private int taxType;

	private int gstApply;

	private double total;

	private float roundoff;

	private String status;

	private int onlineOrder;

	private String razorPayReceiptId;
	private String appPaymentMethod;

	private double paidAmount;
	private int reverseCharge;
	private String pdfToken;
	private String imgLocation;
	private String billingCompanyName;
	private String billingFirstName;
	private String billingLastName;
	private String billingAddressLine1;
	private String billingAddressLine2;
	private String billingCountriesCode;
	private String billingStateCode;
	private String billingCityCode;
	private String billingPinCode;
	private String shippingCompanyName;
	private String shippingFirstName;

	private String shippingLastName;

	private String shippingAddressLine1;

	private String shippingAddressLine2;

	private String shippingCountriesCode;

	private String shippingStateCode;

	private String shippingCityCode;

	private String shippingPinCode;

	private List<SalesItemVo> salesItemVos;

	//private List<SalesAdditionalChargeVo> salesAdditionalChargeVos;

	private int isFeedbackMessageSent;

	private int dayAfterMessage;

	private int isReturn;

	private String vehicleNo;

	private String weight;

	private String referenceNo;

	private String reasonDescription;

	private String Delivertype;

	private String onlinePaymentId;

	private Double onlinePaymentAmount;

	private Date onlinePaymentDate;

	private String onlinePaymentStatus;

	private String onlinePaymentType;

	private int shiprocketLength;

	private int shiprocketWidth;

	private int shiprocketHeight;

	private int shiprocketWeight;

	private int shiprocketOrder_id;

	private int shiprocketShipmentId;

	private String shiprocketStatus;

	private int shiprocketStatusCode;

	private int shiprocketOnboardingCompletedNow;

	private String shiprocketAwbCode;

	private String shiprocketCourierCompanyId;

	private String shiprocketCourierName;

	private int defaultSyncInvoice;

	private float billdiscount;

	String billDiscountType;

	private float flatDiscount;

	private float flatDiscountInAmount;

	private float additionalChargeTotalAmount;

	String flatDiscountType;

	private float totalDisocuntProductwise;

	private long shopifyOrderId;

	private String shopifyOrderNo;

	private String wooCommerceStatus;

	private int wooCommerceOrderId;

	private int isWooCommerceOrder;

	private String wooCommerceTransactionId;

	private String orderType;

	private long tokenNo;

	private long stockTransferId;

	//private DeliveryPartnerVo deliveryPartnerVo;

	private String receiptpaymentType;

	private double commissionPer;

	private double commissionValue;
	
	private double usedCoins;

	//private ContactVo agentVo;
}
