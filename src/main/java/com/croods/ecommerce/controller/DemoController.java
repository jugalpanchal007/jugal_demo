package com.croods.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("")
	public ModelAndView getHomePage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/demo/demo");
		return mv;
	}
}
