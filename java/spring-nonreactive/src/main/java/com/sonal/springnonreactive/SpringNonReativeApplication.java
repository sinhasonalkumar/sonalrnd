package com.sonal.springnonreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sonal.springnonreactive")
public class SpringNonReativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNonReativeApplication.class, args);
	}
}
