package com.croods.ecommerce.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.croods.ecommerce.repo.cms.CmsPageRepository;
import com.croods.ecommerce.service.cms.CmsPageService;
import com.croods.ecommerce.vo.cms.CmsPageType;
import com.croods.ecommerce.vo.cms.CmsPagesVo;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	
	@Autowired
	CmsPageRepository cmsPageRepository;
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app","/token","/queue");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// with sockjs
		registry.addEndpoint("/ws-message").setAllowedOriginPatterns("*").withSockJS();
		// without sockjs
		//registry.addEndpoint("/ws-message").setAllowedOriginPatterns("*");
	}
	
//	@Bean
//    public CmsPageService cmsPageService() {
//        return new CmsPageService() {
//			
//			@Override
//			public CmsPagesVo getCmsPageById(Long id) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public List<CmsPagesVo> getAllCmsPages() {
//				// TODO Auto-generated method stub
//				 return cmsPageRepository.findAll();
//			}
//			
//			@Override
//			public List<CmsPagesVo> findCmsPagesVos(long companyId, long branchId, long userId) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public CmsPagesVo createCmsPage(String type, String content) {
//				CmsPagesVo cmsPage = new CmsPagesVo();
//		        cmsPage.setType(CmsPageType.valueOf(type.toUpperCase()));
//		        cmsPage.setContent(content);
//		        return cmsPageRepository.save(cmsPage);
//
//			}
//		};
//    }
}
