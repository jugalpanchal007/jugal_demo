package com.croods.ecommerce.service.wishlist;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.croods.ecommerce.config.ApiResponse;
import com.croods.ecommerce.constant.Constant;
import com.croods.ecommerce.dto.wishlist.WishlistFetchFromErpDTO;
import com.croods.ecommerce.dto.wishlist.WishlistSaveDTO;
import com.croods.ecommerce.repo.wishlist.WishlistRepository;
import com.croods.ecommerce.service.MainService;
import com.croods.ecommerce.vo.wishlist.WishlistVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@Log
@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	WishlistRepository wishlistRepository;

	@Autowired
	MainService mainService;

	@Autowired
	RestTemplate restTemplate;

	@Value("${base.url}")
	private String baseUrl;

	@Override
	public WishlistVo saveProductIntoWishlist(WishlistSaveDTO wishlistSaveDTO, long userFrontId, long branchId,
			long companyId) {

		try {
			WishlistVo wishlistVo = new WishlistVo();
//			Add Business Logic
			wishlistVo.setCompanyId(companyId);
			wishlistVo.setBranchId(branchId);
			wishlistVo.setUserFrontId(userFrontId);
			wishlistVo.setCreatedBy(wishlistSaveDTO.getContactId());
			wishlistVo.setAlterBy(wishlistSaveDTO.getContactId());
			wishlistVo.setContactId(wishlistSaveDTO.getContactId());
			wishlistVo.setProductId(wishlistSaveDTO.getProductId());
			wishlistVo.setProductvarientId(wishlistSaveDTO.getProductVarientId());
			wishlistVo.setProductName(wishlistSaveDTO.getProductName());
			wishlistVo.setProductImage(wishlistSaveDTO.getImage());
			wishlistVo.setMrp(wishlistSaveDTO.getMrp());
			wishlistVo.setSellingPrice(wishlistSaveDTO.getSellingPrice());
			wishlistVo.setHaveVariations(wishlistSaveDTO.getHaveVariations());

			WishlistVo wishlistVonew = wishlistRepository.save(wishlistVo);
			return wishlistVonew;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int removeProductFromWishlist(long wishlistId) {
		int result = wishlistRepository.removeProductFromWishlist(wishlistId);
		return result;
	}

	@Override
	public List<WishlistVo> getWishlistByContactId(long contactId) {
		List<WishlistVo> list = wishlistRepository.findByContactId(contactId);

		return list;
	}

	@Override
	public List<WishlistFetchFromErpDTO> getWishlistFetchDtoForErp(long contactId) {
		return wishlistRepository.getWishlistFetchDtoForErp(contactId);
	}

	@Override
	public ApiResponse getWishlistForRealTimeStockFromErp(List<WishlistFetchFromErpDTO> list,String API_TOKEN) {
		ApiResponse apiResponse = new ApiResponse();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constant.API_KEY, API_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);

		String data = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.err.println("DATA ::: " + data);

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);
		String URL = baseUrl.concat(Constant.API + "/products/wishlist");
		try {
			apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
			log.severe("::: RESPONSE Of getWishlistForRealTimeStockFromErp ::: " + apiResponse.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

//	@Override
//	public List<Map<String, String>> getWishlistForRealTimeStockFromErp(long contactId, String API_TOKEN) {
//		
//		List<Map<String, String>> wishlist = null;
//		String ids = wishlistRepository.findProductVarientsIdsByContactId(contactId);
//
//		if (StringUtils.isNotBlank(ids)) {
//			try {
//				ApiResponse apiResponse = new ApiResponse();
//				HttpHeaders headers = new HttpHeaders();
//				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//				headers.set(Constant.API_KEY, API_TOKEN);
//				headers.setContentType(MediaType.APPLICATION_JSON);
//
//				String data = "";
//				ObjectMapper mapper = new ObjectMapper();
//				try {
//					data = mapper.writeValueAsString(ids);
//				} catch (JsonProcessingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//				System.err.println("DATA ::: " + data);
//
//				HttpEntity<String> entity = new HttpEntity<String>(data, headers);
//
//				String URL = baseUrl.concat(Constant.API + "/products/wishlist?productVariantIds=" + ids);
//				try {
//					apiResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, ApiResponse.class).getBody();
//					log.severe("::: RESPONSE Of getTopCategoriesList ::: " + apiResponse.getResponse());
//					
//					if (apiResponse.isStatus()) {
//						wishlist = (List<Map<String, String>>) apiResponse.getResponse();
//					}else {
//						wishlist = null;
//					}
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		} else {
//
//		}
//
//		return wishlist;
//	}

}
