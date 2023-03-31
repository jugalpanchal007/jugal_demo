package com.croods.ecommerce.service.dateFilter;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croods.ecommerce.repo.dateFilter.DateFilterRepository;
import com.croods.ecommerce.vo.dateFilter.DateFilterVo;

@Service
public class DateFilterServiceImpl  implements DateFilterService{

	
	@Autowired
	DateFilterRepository dateFilterRepository;
	
	
	@Override
	public List<DateFilterVo> getDataByDate(LocalDate startDate, LocalDate endDate) {
		return dateFilterRepository.findByDateBetween(startDate, endDate);
	}

}
