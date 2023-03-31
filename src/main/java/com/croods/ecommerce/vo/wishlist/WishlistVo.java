package com.croods.ecommerce.vo.wishlist;

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
@Table(name = "wishlist")
@Getter
@Setter
public class WishlistVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id", length = 10)
	private long wishlistId;

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
	
	@Column(name = "contact_id")
	private long contactId;
	
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_varient_id")
	private long productvarientId;
	
	@Column(name = "product_name",columnDefinition = "TEXT")
	private String productName;
	
	@Column(name = "mrp", columnDefinition = "double precision default 0.0")
    private double mrp;
	
	@Column(name = "selling_price", columnDefinition = "double precision default 0.0")
    private double sellingPrice;
	
//	@Column(name = "category_id")
//	private long caegoryId;
//
//	@Column(name = "brand_id")
//	private long brandId;
	
	@Column(name = "is_deleted", length = 1, columnDefinition = "int default 0")
	private int isDeleted;
	
	@Column(name = "is_save_later", length = 1, columnDefinition = "int default 0")
	private int isSaveLater;
	
	@Column(name = "product_image",columnDefinition = "TEXT")
	private String productImage;
	
	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@CreationTimestamp
	@Column(name = "modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	
	@Column(name = "have_variations", length = 1, columnDefinition = "int default 0")
	private int haveVariations;
}
