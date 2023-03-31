package com.croods.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConatctAddressDto {

    public String cityCode;
    public String cityName;
    public String stateCode;
    public String countriesCode;
    public String countriesName;
    public long contactId;
    public int isDeleted;
    public String addressLine1;
    public String addressLine2;
    public String companyName;
    public String firstName;
    public String lastName;
    public String pinCode;
    public long contactAddressId;
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
}