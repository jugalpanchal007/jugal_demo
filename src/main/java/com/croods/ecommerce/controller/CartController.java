package com.croods.ecommerce.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.constant.Constant;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/cart")
public class CartController {

	@RequestMapping("/addtocart/{type}")
	@ResponseBody
	public ApiResponse addAndMinusTocart(@RequestParam Map<String, String> allRequestParams, @PathVariable("type") String type,
			HttpSession session, HttpServletRequest request, HttpServletResponse response) {		
		log.severe("CONTACTID" + session.getAttribute("contactId"));
	    long productVarientId =  Long.parseLong(allRequestParams.get("productVarientId").toString());
	    double price = Double.parseDouble(allRequestParams.get("price").toString());
	    float quantity  = Float.parseFloat(allRequestParams.get("quantity").toString());
	    String stockIdString =  allRequestParams.get("stockId");
	    		
	    long stockId = 0;
	    
	    if (StringUtils.isNotBlank(stockIdString)) {
	    	stockId = Long.parseLong(stockIdString);
		}
	    
	    log.severe("STOCKID ::  "+ stockId);
	    
	    
		ApiResponse apiResponse = new ApiResponse();

		if (session.getAttribute("contactId") != null) {
			if (StringUtils.isNoneBlank(type)) {

				List<Map<String, Object>> cartList = (List<Map<String, Object>>) session.getAttribute("cartList");
				boolean repeat = false;
				String message = "";
				boolean status = false;
				int index = 0;

				for (int i = 0; i < cartList.size(); i++) {
					if (Long.parseLong(cartList.get(i).get("productVarientId").toString()) == productVarientId) {
						repeat = true;
						index = i;
						break;
					}
				}
				Map<String, Object> cartMap = null;
				if(cartList.isEmpty()) {
					cartMap = new HashMap<>();
				}else {
					if(repeat == false) {
						cartMap = new HashMap<>();
					}else {
						cartMap = cartList.get(index);	
					}
					
				}
				
				float qty = 1;
				if (cartMap.isEmpty()) {// For First time add data into cart
					if (type.equalsIgnoreCase(Constant.CART_ADD_QUANTITY)) {
						
						cartMap.put("productVarientId", productVarientId);
						cartMap.put("price", price);
						cartMap.put("qty", qty);
						cartMap.put("stockId", stockId);
						status = true;
						message = "Product Added To Cart";

					} else {
						status = false;
						message = "Quantity Can't be minus";
					}
					cartList.add(cartMap);
				} else {
					if(repeat == false) {
						if (type.equalsIgnoreCase(Constant.CART_ADD_QUANTITY)) {
							
							cartMap.put("productVarientId", productVarientId);
							cartMap.put("price", price);
							cartMap.put("qty", qty);
							cartMap.put("stockId", stockId);
							status = true;
							message = "Product Added To Cart";

						} else {
							status = false;
							message = "Quantity Can't be minus";
						}
						cartList.add(cartMap);
					}else {
						qty = (float) cartMap.get("qty");
						log.severe("QUANTITY :::: " + qty);
						if (type.equalsIgnoreCase(Constant.CART_ADD_QUANTITY)) {

							cartMap.put("qty", qty + 1);

							status = true;
							message = "Quantity Added To Cart";

						} else if (type.equalsIgnoreCase(Constant.CART_MINUS_QUANTITY)) {
							if (qty != 0) {
								if (qty == 1) {
									cartMap = null;
								}else {
									cartMap.put("qty", qty - 1);	
								}
								
							} else {
								cartMap.put("qty", 0);
							}

							status = true;
							message = "Quantity Deleted From Cart";

						} else {

							status = false;
							message = "Something Went Wrong";

						}
						if(cartMap!=null) {
							cartList.set(index, cartMap);	
						}else {
							
							cartList.remove(index);
						}	
					}
					
					
					
				}

				

				session.setAttribute("cartList", cartList);

				log.info("CART LIST ::: " + cartList);
				apiResponse = new ApiResponse(status, message, cartList);

			} else {
				apiResponse = new ApiResponse(false, "Error In Add To Cart", "Error In Add To Cart");
			}
		} else {
			apiResponse = new ApiResponse(false, "Please Login Again", null);
		}

		return apiResponse;

	}

	@RequestMapping("/getlist")
	@ResponseBody
	public ApiResponse getCart( HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		ApiResponse apiResponse = new ApiResponse();
		
		
		if( session.getAttribute("cartList") != null ) {
			List<Map<String, Object>> cartList = (List<Map<String, Object>>) session.getAttribute("cartList");
			
			if (cartList.isEmpty()) {
				log.info("CART LIST ::: " + cartList);
				apiResponse = new ApiResponse(false, "Cart Is Empty", null);
			} else {
				log.info("CART LIST ::: " + cartList);
				apiResponse = new ApiResponse(true, "Cart Found", cartList);
			}
		}else{
			
			apiResponse = new ApiResponse(false, "Cart Not Found", null);
		}

		
		

		return apiResponse;

	}
	
	
	@RequestMapping("/disgardCart")
	@ResponseBody
	public ApiResponse disgardCart( HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		ApiResponse apiResponse = new ApiResponse();
		try {
			session.removeAttribute("cartList");
			List<Map<String, Object>> cartList = new ArrayList<>();
			session.setAttribute("cartList", cartList);
			
			apiResponse = new ApiResponse(true, "Cart Disgarded", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse = new ApiResponse(false, "Something Went", null);
		}
		return apiResponse;

	}

}
