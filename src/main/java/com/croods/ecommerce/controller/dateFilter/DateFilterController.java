package com.croods.ecommerce.controller.dateFilter;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.croods.ecommerce.service.dateFilter.DateFilterService;
import com.croods.ecommerce.vo.dateFilter.DateFilterVo;

@RestController
@RequestMapping("/date/filter")
public class DateFilterController {

	@Autowired
	private DateFilterService dateFilterService;

	@GetMapping("/data")
    public List<DateFilterVo> getData(@RequestParam("startDate") String startDateString,
    			@RequestParam("endDate") String endDateString) {
			LocalDate startDate = LocalDate.parse(startDateString);
				LocalDate endDate = LocalDate.parse(endDateString);
					return dateFilterService.getDataByDate(startDate, endDate);

}
}