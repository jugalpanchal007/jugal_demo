package com.croods.ecommerce.vo.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "api_token")
@Data
public class APITokenVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "api_token_id", length = 10)
	private long apiTokenId;

	@Column(name = "user_front_id")
	private long userFrontId;

	@Column(name = "erp_user_front_id")
	private long erpUserFrontId;

	@Column(name = "token")
	private String token;

	@Column(name = "status")
	private int status;

	@Column(name = "company_id", columnDefinition = "bigint default 0")
	private long companyId;

	@Column(name = "branch_id", columnDefinition = "bigint default 0")
	private long branchId;

	@Column(name = "is_deleted", length = 1, columnDefinition = "int default 0")
	private int isDeleted;

	@Column(name = "allowed_ip_addresses", columnDefinition = "text")
	private String allowedIpAddresses;

	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@CreationTimestamp
	@Column(name = "modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

}
