package com.croods.ecommerce.vo.banner;

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
@Table(name = "banner")
@Getter
@Setter
public class BannerVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banner_id", length = 10)
	private long banner_id;

	@Column(name = "banner_title", length = 30)
	private String bannerTitle;

	@Column(name = "banner_sub_title", length = 30)
	private String bannerSubTitle;

	@Column(name = "src", columnDefinition = "TEXT")
	private String src;

	@Column(name = "signed_src", columnDefinition = "TEXT")
	private String signedSrc;

	@Column(name = "order_By")
	private int orderBy;

	@Column(name = "user_front_id")
	private long userFrontId;
	
	@Column(name = "company_id")
	private long companyId;

	@Column(name = "branch_id")
	private long branchId;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "alter_by")
	private long alterBy;
	
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

}