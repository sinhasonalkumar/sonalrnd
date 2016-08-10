package com.sonal.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //or @EnableDiscoveryClient
public class CoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreServiceApplication.class, args);
	}
}
