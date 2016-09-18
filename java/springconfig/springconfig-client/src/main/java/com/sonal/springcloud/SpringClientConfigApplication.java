package com.sonal.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringClientConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClientConfigApplication.class, args);
	}
}
