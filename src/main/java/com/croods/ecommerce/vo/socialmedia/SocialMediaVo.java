package com.croods.ecommerce.vo.socialmedia;

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
@Table(name = "social_media")
@Getter
@Setter
public class SocialMediaVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "social_media_id", length = 10)
	private long socialMediaId;

	@Column(name = "social_media_type", length = 20)
	private String socialMediaType;

	@Column(name = "social_media_link", columnDefinition = "text")
	private String socialMediaLink;

	@Column(name = "company_id")
	private long companyId;

	@Column(name = "branch_id")
	private long branchId;

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
