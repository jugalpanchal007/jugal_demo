package com.croods.ecommerce.vo.userfront;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.croods.ecommerce.vo.socialmedia.SocialMediaVo;

import lombok.Data;

@Entity
@Table(name = "ecommerce_user_front")
@Data
public class EcommerceUserfrontVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ecommerce_user_front_id", length = 10)
	private long ecommerceUserfrontId;

	@Column(name = "company_id")
	private long companyId;

	@Column(name = "branch_id")
	private long branchId;

	@Column(name = "countries_code", length = 20)
	private String countriesCode;

	@Column(name = "description", length = 100)
	private String description;

	@Column(name = "countries_name", length = 200)
	private String countriesName;

	@Column(name = "zone_code", length = 20)
	private String zoneCode;

	@Column(name = "state_code", length = 20)
	private String stateCode;

	@Column(name = "state_name", length = 200)
	private String stateName;

	@Column(name = "city_code", length = 20)
	private String cityCode;

	@Column(name = "city_name", length = 200)
	private String cityName;

	@Column(name = "name", length = 150)
	private String name;

	@Column(name = "email", length = 80)
	private String email;

	@Column(name = "address", length = 200)
	private String address;

	@Column(name = "address2", length = 200)
	private String address2;

	@Column(name = "pincode", length = 50)
	private String pincode;

//	@Column(name = "contact_name", length = 100)
//	private String contactName;

	@Column(name = "contact_no", length = 30)
	private String contactNo;

//	@Column(name = "user_name", length = 50)
//	private String userName;
//
//	@Column(name = "password")
//	private String password;

	@Column(name = "fssai_no", length = 20)
	private String fssaiNo;

	@Column(name = "pan_no", length = 30)
	private String panNo;

	@Column(name = "telephone", length = 20)
	private String telephone;

	@Column(name = "website", length = 100)
	private String website;

	@Column(name = "status", length = 20)
	private String status;

	@Column(name = "is_deleted", length = 1, columnDefinition = "int default 0")
	private int isDeleted;

	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@CreationTimestamp
	@Column(name = "modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	@Column(name = "logo", columnDefinition = "TEXT")
	private String logo;

	@Column(name = "logo_signed_src", columnDefinition = "TEXT")
	private String logoSignedSrc;

	@Column(name = "host_name", length = 50, nullable = true)
	private String hostName;

	@Column(name = "allowed_google_location_places", length = 50, nullable = true)
	private String allowedGoogleLocationPlaces;

	@Column(name = "erp_user_front_id")
	private long erpUserfrontId;
	
	@Transient
	private List<SocialMediaVo> socialMediaVos;
	

}