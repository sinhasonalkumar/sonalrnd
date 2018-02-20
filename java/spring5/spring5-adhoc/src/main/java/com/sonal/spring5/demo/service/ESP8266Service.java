package com.sonal.spring5.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ESP8266Service {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass()); 

    @Autowired
    private WebClient esp8266Client;
    
    public Mono<String> turnOnOff(Integer gpioValue) {
	
	logger.info("Request : " + gpioValue);
	
	Mono<String> gpioResponse = esp8266Client.get()
			.uri("/gpio/" + gpioValue)
			.retrieve()
			.bodyToMono(String.class)
			.log();
	
	
	
	return gpioResponse;
    }
}
