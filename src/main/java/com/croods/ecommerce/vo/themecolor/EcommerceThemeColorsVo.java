package com.croods.ecommerce.vo.themecolor;

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

@Getter
@Setter
@Entity
@Table(name = "ecommerce_theme_colors")
public class EcommerceThemeColorsVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ecommerce_theme_color_id", length = 10)
	private long ecommerceThemeColorId;

	@Column(name = "user_front_id")
	private long userfrontId;

	@Column(name = "primary_color", length = 200)
	private String primaryColor;
	@Column(name = "secondary_color", length = 200)
	private String secondaryColor;
	@Column(name = "heading_color", length = 200)
	private String headingColor;
	@Column(name = "footer_color", length = 200)
	private String footerColor;

	@Column(name = "footer_text_color", length = 200)
	private String footerTextColor;
	
	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@CreationTimestamp
	@Column(name = "modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
}
