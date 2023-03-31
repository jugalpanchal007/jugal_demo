package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactAddressRequestDTO {

    public String cityCode;
    public String cityName;
    public String stateCode;
    public String countriesCode;
    public String countriesName;
    public String contactId;
    public int isDeleted;
    public String addressLine1;
    public String addressLine2;
    public String companyName;
    public String firstName;
    public String lastName;
    public String pinCode;
    public String contactAddressId;
    public String addressLine3;
    public double lat;
    public double lng;
    public String phoneNo;
    public String place;
    public String zoneCode;
    public String localityCode;
    public int isDefault;
    public String stateName;
    public String name;
    public String addressType;
    public String nameTitle;
    public String type;
    public String landMark;
    public String alternateMobileNumber;
}