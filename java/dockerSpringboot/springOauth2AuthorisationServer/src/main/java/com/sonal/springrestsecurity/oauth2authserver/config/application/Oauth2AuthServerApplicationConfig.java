package com.sonal.springrestsecurity.oauth2authserver.config.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sonal.springrestsecurity"})
public class Oauth2AuthServerApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthServerApplicationConfig.class, args);
    }
}
