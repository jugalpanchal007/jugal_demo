package com.croods.ecommerce.vo.EcommerceAdmin;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ecommerce_admin")
@Getter
@Setter
public class EcommerceAdminVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ecommerce_admin_id")
	private long ecommerceAdminId;

	@Column(name = "value", columnDefinition = "text")
	private String value;

	@Column(name = "type")
	private String type;

	@Column(name = "company_id", length = 10, updatable = false)
	private long companyId;

	@Column(name = "branch_id", columnDefinition = "bigint default 0")
	private long branchId;

	@Column(name = "user_id", columnDefinition = "bigint default 0")
	private long userId;
	
	
	@Column(name = "user_front_id")
	private long userFrontId;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "alter_by")
	private long alterBy;

	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@CreationTimestamp
	@Column(name = "modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

}
