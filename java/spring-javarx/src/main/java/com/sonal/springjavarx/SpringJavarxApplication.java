package com.sonal.springjavarx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sonal.springjavarx")
public class SpringJavarxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavarxApplication.class, args);
	}
}
