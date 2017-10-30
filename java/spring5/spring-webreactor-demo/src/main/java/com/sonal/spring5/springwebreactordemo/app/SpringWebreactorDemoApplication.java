package com.sonal.spring5.springwebreactordemo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.sonal.spring5"})
public class SpringWebreactorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebreactorDemoApplication.class, args);
	}
}
