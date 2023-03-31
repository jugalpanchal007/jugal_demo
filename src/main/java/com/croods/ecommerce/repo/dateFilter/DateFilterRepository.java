package com.croods.ecommerce.repo.dateFilter;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.croods.ecommerce.vo.dateFilter.DateFilterVo;

public interface DateFilterRepository extends JpaRepository<DateFilterVo, Long>{

	List<DateFilterVo> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
