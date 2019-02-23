package com.zjzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.*")
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableCaching
public class Zjzx_search9087 {
	public static void main(String[] args) {
		SpringApplication.run(Zjzx_search9087.class, args);
	}
}

// public class ZjzxBootControllerApplication extends
// SpringBootServletInitializer{
// @Override
// protected SpringApplicationBuilder configure(
// SpringApplicationBuilder builder) {
// // TODO Auto-generated method stub
// return builder.sources(ZjzxBootControllerApplication.class);
// }
// public static void main(String[] args) {
// SpringApplication.run(ZjzxBootControllerApplication.class, args);
// }
// }

