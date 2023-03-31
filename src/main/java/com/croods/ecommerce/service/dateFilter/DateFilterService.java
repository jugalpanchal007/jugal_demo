package com.croods.ecommerce.service.dateFilter;

import java.time.LocalDate;
import java.util.List;

import com.croods.ecommerce.vo.dateFilter.DateFilterVo;

public interface DateFilterService {

	
	List<DateFilterVo> getDataByDate(LocalDate startDate, LocalDate endDate);
}
