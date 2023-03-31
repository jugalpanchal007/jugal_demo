package com.croods.ecommerce;

import java.time.Instant;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.croods.ecommerce.service.cms.CmsPageService;
import com.croods.ecommerce.vo.profile.FileStorageProperties;



@SpringBootApplication

@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class EcommerceSpringApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSpringApp.class, args);
	}

	@Primary
	@Bean
	public TaskExecutor primaryTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// add necessary properties to the executor
		return executor;
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@PostConstruct
	public void init() {
		Instant instant = Instant.now();
		System.out.println(instant.toString());
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata")); // It will set UTC timezone
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EcommerceSpringApp.class);
	}
}
