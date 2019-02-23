package com.zjzx.serviceconfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.jfinal.aop.Duang;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.zjzx.service.SearchService;

@Configuration
public class BeanConfiguration {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	@Bean
	public SearchService searchService() {
		return Duang.duang(SearchService.class, Tx.class);
	}


	
	

}
