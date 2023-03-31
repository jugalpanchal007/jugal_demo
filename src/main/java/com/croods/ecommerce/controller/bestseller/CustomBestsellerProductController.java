package com.croods.ecommerce.controller.bestseller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.dto.CustomBestsellerProductDTO;
import com.croods.ecommerce.repo.bestseller.CustomBestsellerProductRepository;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.bestseller.CustomBestsellerProductService;
import com.croods.ecommerce.vo.api.APITokenVo;
import com.croods.ecommerce.vo.bestseller.CustomBestSellerVo;

@RestController
@RequestMapping("/customBestsellerProducts")
public class CustomBestsellerProductController {
		
	
	    @Autowired
	    CustomBestsellerProductService customBestsellerProductService;
	    
	    @Autowired
	    CustomBestsellerProductRepository customBestsellerProductRepository;
	    
	    
	    @Autowired
		APITokenService apiTokenService;
	    
	    @PostMapping("/add")
	    public ApiResponse createCustomBestsellerProduct(@RequestBody CustomBestsellerProductDTO customBestsellerProductDTO, 
	    		@RequestHeader("API_TOKEN") String API_TOKEN) {
	    	
	    	APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
	    	
	        if (apiToken == null) {
	          //  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid API token");
	        	return new ApiResponse(false,"API_TOKEN NOT_FOUND",ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid API token"));
	        }
	        
	        CustomBestSellerVo customBestsellerProduct = new CustomBestSellerVo();
	        customBestsellerProduct.setProductId(customBestsellerProductDTO.getProductId());
	        customBestsellerProduct.setProductVariantId(customBestsellerProductDTO.getProductVariantId());
	        customBestsellerProduct.setPosition(customBestsellerProductDTO.getPosition());

	        customBestsellerProductRepository.save(customBestsellerProduct);
	        
	        //return ResponseEntity.status(HttpStatus.CREATED).build();
	        return new ApiResponse(true,"Added Sucssesfully",customBestsellerProduct);
	    }

	    @GetMapping
	    public ApiResponse findAll() {
	       // return customBestsellerProductService.findAll();
	    	try {
				return new ApiResponse(true,"List Of BestSeller Products",customBestsellerProductService.findAll());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return new ApiResponse(false,"Something Problem Happens",e);
			}
	    }
	    @GetMapping("/{id}")
	    public ApiResponse findById(@PathVariable Long id) {
	        Optional<CustomBestSellerVo> customBestsellerProduct = customBestsellerProductService.findById(id);
	        
	        if (customBestsellerProduct.isPresent()) {
	            return new ApiResponse(true, "List Of BestSeller Products By id", customBestsellerProduct.get());
	        } else {
	            return new ApiResponse(false, "BestSeller Product not found", null);
	        }
	    }
	    
//	    @GetMapping("/position/{id}")
//	    public ApiResponse findByPositonId(@PathVariable Integer id) {
//	        Optional<CustomBestSellerVo> customBestsellerProduct = customBestsellerProductService.findByPositon(id);
//	        
//	        if (customBestsellerProduct.isPresent()) {
//	            return new ApiResponse(true, "List Of BestSeller Products By id", customBestsellerProduct.get());
//	        } else {
//	            return new ApiResponse(false, "BestSeller Product not found", null);
//	        }
//	    }


	    @DeleteMapping("/{id}")
	    public void deleteById(@PathVariable Long id) {
	        customBestsellerProductService.deleteById(id);
	    }
	    
	    
	    @PutMapping("/update/{id}")
	    public ApiResponse updateCustomBestsellerProduct(@PathVariable("id") Long id, @RequestBody CustomBestsellerProductDTO customBestsellerProductDTO, 
	    		@RequestHeader("API_TOKEN") String API_TOKEN) {

	       
	        APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
	        if (apiToken == null) {
	            return new ApiResponse(false,"API_TOKEN NOT_FOUND",ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid API token"));
	        }
	        
	      
	        Optional<CustomBestSellerVo> optionalEntity = customBestsellerProductRepository.findById(id);
	        if (!optionalEntity.isPresent()) {
	            return new ApiResponse(false,"CustomBestsellerProduct not found",ResponseEntity.status(HttpStatus.NOT_FOUND).body("CustomBestsellerProduct not found"));
	        }

	      
	        CustomBestSellerVo customBestsellerProduct = optionalEntity.get();
	        customBestsellerProduct.setProductId(customBestsellerProductDTO.getProductId());
	        customBestsellerProduct.setProductVariantId(customBestsellerProductDTO.getProductVariantId());
	        customBestsellerProduct.setPosition(customBestsellerProductDTO.getPosition());
	        customBestsellerProductRepository.save(customBestsellerProduct);

	        return new ApiResponse(true,"Updated successfully",customBestsellerProduct);
	    }



}
