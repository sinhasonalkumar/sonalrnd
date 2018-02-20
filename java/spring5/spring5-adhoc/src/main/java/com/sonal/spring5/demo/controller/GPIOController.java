package com.sonal.spring5.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.spring5.demo.service.ESP8266Service;

import reactor.core.publisher.Mono;

@RestController
public class GPIOController {

    @Autowired
    private ESP8266Service esp8266Service;

    @GetMapping(value = "gpio/{gpioValue}")
    public Mono<String> turnOnOff(@PathVariable("gpioValue") Integer gpioValue) {
	return esp8266Service.turnOnOff(gpioValue);
    }
}
