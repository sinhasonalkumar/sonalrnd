package com.sonal.spring5.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestClient {

    @Bean
    public WebClient esp8266Client() {
	return WebClient.create("http://192.168.0.108");
    }
}
