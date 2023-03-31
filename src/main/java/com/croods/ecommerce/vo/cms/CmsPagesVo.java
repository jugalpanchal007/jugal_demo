package com.croods.ecommerce.vo.cms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cms_pages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CmsPagesVo {

	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "cms_page_id", length = 10)
	    private long cmsPageId;
		
		@Enumerated(EnumType.STRING)
		@Column(name = "cms_page_type")
	    private CmsPageType cmsPageType;
		
		
		@Column(name = "cms_page_content", columnDefinition = "TEXT")
	    private String cmsPageContent;
		
		
			@Column(name = "branch_id", length = 10)
		    private long branchId;
		 
			@Column(name = "user_front_id" , length = 10)
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
