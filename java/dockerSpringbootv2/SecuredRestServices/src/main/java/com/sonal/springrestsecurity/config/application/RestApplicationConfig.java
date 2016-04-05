package com.sonal.springrestsecurity.config.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sonal.springrestsecurity"})
public class RestApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(RestApplicationConfig.class, args);
    }
}
