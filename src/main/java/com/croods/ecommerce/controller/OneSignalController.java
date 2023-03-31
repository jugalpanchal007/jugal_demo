package com.croods.ecommerce.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.service.MainService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/onesignal")
public class OneSignalController {

	
	@Autowired
	MainService mainService;
	
	 @RequestMapping("/save")
	 @ResponseBody
		public ApiResponse saveOneSignalUserId(@RequestParam("id") String userId,HttpSession session){
		 	ApiResponse apiResponse = new ApiResponse();
			 log.severe("::::::: CONTACT ID  :::: "+userId);
			 try {
				apiResponse = mainService.saveOneSignalUserId(userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 return apiResponse;

		}
	 @RequestMapping("/delete")
	 @ResponseBody
	 public ApiResponse deleteOneSignalUserId(@RequestParam("id") String userId,HttpSession session){
		 	ApiResponse apiResponse = new ApiResponse();
			 log.severe("::::::: CONTACT ID  :::: "+userId);
			 try {
				apiResponse = mainService.deleteOneSignalUserId(userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 return apiResponse;

		}
}