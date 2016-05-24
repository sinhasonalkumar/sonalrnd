package com.logback.config.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAsync
@EnableWebMvc
@ComponentScan("com.logback")
@Configuration
@PropertySource(value = "classpath:default.properties")
public class DockerLogbackApp {

	public static void main(String[] args) {
		SpringApplication.run(DockerLogbackApp.class, args);
	}
}
