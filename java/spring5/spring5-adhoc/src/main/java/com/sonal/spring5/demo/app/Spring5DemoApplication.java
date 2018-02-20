package com.sonal.spring5.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.sonal.spring5"})
public class Spring5DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5DemoApplication.class, args);
	}
}
