package com.sonal.springrestsecurity.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableAsync
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.sonal.springrestsecurity"})
public class MDCApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(MDCApplicationConfig.class, args);
    }
}
