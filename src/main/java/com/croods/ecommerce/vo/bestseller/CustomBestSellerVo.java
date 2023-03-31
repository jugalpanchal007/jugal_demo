package com.croods.ecommerce.vo.bestseller;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "custom_bestseller_products")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomBestSellerVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custom_bestseller_product_id;

	@Column(nullable = false)
	private Long productId;

	@Column(nullable = false)
	private Long productVariantId;

	@Column(nullable = false)
	private Integer position;

	
	
	
	
	@Column(name = "branch_id", length = 10)
	private long branchId;

	@Column(name = "user_front_id", length = 10)
	private long userFrontId;

	@Column(name = "company_id", length = 10)
	private long companyId;

	@Column(name = "alterby_id", length = 10)
	private long alterBy;

	@Column(name = "createdby_id", length = 10)
	private long createdBy;

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
