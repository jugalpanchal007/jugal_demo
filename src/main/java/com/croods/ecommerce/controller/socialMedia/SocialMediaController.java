package com.croods.ecommerce.controller.socialMedia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.service.api.APITokenService;
import com.croods.ecommerce.service.socialmedia.SocialMediaService;
import com.croods.ecommerce.vo.api.APITokenVo;

@RestController
@RequestMapping("/socialMedia")
public class SocialMediaController {

	

    @Autowired
	APITokenService apiTokenService;
    
    @Autowired
    SocialMediaService  socialMediaService;
	
	
	@PostMapping("/")
	public ResponseEntity<String> saveSocialMedia(@RequestHeader(value = "API_TOKEN") String API_TOKEN,
	        @RequestParam("type") String type, @RequestParam("link") String link) {

		APITokenVo apiToken = apiTokenService.findByToken(API_TOKEN);
    	
		
	    // check if the API_TOKEN header is present and not null
	    if ( apiToken == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("API_TOKEN header is missing or empty");
	    }

	    // check if type is a valid social media type
	    if (!isValidSocialMediaType(type)) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid social media type");
	    }

	    
	   
	    // create a map with the social media data
	    Map<String, String> socialMediaData = new HashMap<>();
	    socialMediaData.put(type, link);

	    // save the social media data using the service
	    String result = socialMediaService.saveSocialMedia(socialMediaData, link);

	    // return the result as a response entity
	    if ("true".equals(result)) {
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save social media data");
	    }
	}

        
        private boolean isValidSocialMediaType(String type) {
            return Arrays.asList(Constant.FACEBOOK, Constant.INSTAGRAM,Constant.LINKEDIN,Constant.YOUTUBE,
            		Constant.GMAIL)
                    .contains(type);

        }
      
 
}
