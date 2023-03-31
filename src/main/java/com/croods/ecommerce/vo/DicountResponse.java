package com.croods.ecommerce.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class DicountResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "status")
    private boolean status;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "DiscountType")
    private String DiscountType;

    @JsonProperty(value = "Discount")
    private String Discount;

    @JsonProperty(value = "AppliesTo")
    private String AppliesTo;

    @JsonProperty(value = "AppliesCategoryId")
    private String AppliesCategoryId;

    @JsonProperty(value = "AppliesBrandId")
    private String AppliesBrandId;

    @JsonProperty(value = "AppliesProductId")
    private String AppliesProductId;

    @JsonProperty(value = "MinimumRequirement")
    private String MinimumRequirement;

    @JsonProperty(value = "purchaseAmount")
    private String purchaseAmount;

    @JsonProperty(value = "quantityOfItem")
    private String quantityOfItem;

    @JsonProperty(value = "CustomerBuysQuantity")
    private String CustomerBuysQuantity;

    @JsonProperty(value = "CustomerGetQuantity")
    private String CustomerGetQuantity;

    @JsonProperty(value = "CustomerBuysProductId")
    private String CustomerBuysProductId;

    @JsonProperty(value = "CustomerGetProductId")
    private String CustomerGetProductId;

    @JsonProperty(value = "TotalUsageLimits")
    private String TotalUsageLimits;

    @JsonProperty(value = "UsageLimits")
    private String UsageLimits;

    @JsonProperty(value = "oncePerCustomer")
    private String oncePerCustomer;

    @JsonProperty(value = "oncePerCustomerUses")
    private String oncePerCustomerUses;

    @JsonProperty(value = "CustomerEligibility")
    private String CustomerEligibility;

    @JsonProperty(value = "CustomerEligibilityIds")
    private String CustomerEligibilityIds;


    @JsonProperty(value = "DiscountApplicable")
    private String DiscountApplicable;

    @JsonProperty(value = "customerOldEligibility")
    private String customerOldEligibility;


}
