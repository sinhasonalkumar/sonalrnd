package com.sonal.springrestsecurity.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sonal.springrestsecurity"})
public class Oauth2RestApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2RestApplicationConfig.class, args);
    }
}
