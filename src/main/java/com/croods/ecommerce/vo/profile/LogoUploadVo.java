package com.croods.ecommerce.vo.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "logo")
@Data
@NoArgsConstructor

public class LogoUploadVo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logo_id", length = 10)
	private long logo_id;

	@Column(name = "fileName", length = 30)
	private String fileName;

	@Column(name = "img_src", columnDefinition = "TEXT")
	private String imgsrc;

	@Column(name = "signed_src", columnDefinition = "TEXT")
	private String signedSrc;

	@Column(name = "order_By")
	private int orderBy;

	@Column(name = "user_front_id")
	private long userFrontId;
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//	
//	private String fileName;
//    private String fileDownloadUri;
//    private String fileType;
//    private long size;
//    
//	public LogoUploadVo(Long id, String fileName, String fileDownloadUri, String fileType, long size) {
//		super();
//		this.id = id;
//		this.fileName = fileName;
//		this.fileDownloadUri = fileDownloadUri;
//		this.fileType = fileType;
//		this.size = size;
//	}
    
	
    
    
}
