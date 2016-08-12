package com.sonal.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sonal.spring5")
public class ScratchpadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScratchpadApplication.class, args);
	}
}
