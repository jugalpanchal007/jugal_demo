package com.croods.ecommerce.repo.profile;

import org.springframework.data.jpa.repository.JpaRepository;

import com.croods.ecommerce.vo.profile.MyProfileVo;





public interface MyProfileRepository  extends JpaRepository<MyProfileVo, Long> {

}
