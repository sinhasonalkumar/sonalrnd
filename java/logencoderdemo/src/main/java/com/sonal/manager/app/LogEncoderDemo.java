package com.sonal.manager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sonal.manager")
public class LogEncoderDemo {

	public static void main(String[] args) {
		SpringApplication.run(LogEncoderDemo.class, args);
	}
}
