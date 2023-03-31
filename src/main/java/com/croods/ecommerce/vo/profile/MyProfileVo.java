package com.croods.ecommerce.vo.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyProfileVo {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String profileImageUrl; 
    
	@Column(name = "company_id", length = 10, updatable = false)
	private long companyId;

	@Column(name = "branch_id", columnDefinition = "bigint default 0")
	private long branchId;

	@Column(name = "user_id", columnDefinition = "bigint default 0")
	private long userId;
    
    
   
    
}


