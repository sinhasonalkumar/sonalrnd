package com.sonal.springrestsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureControllerB {

    @RequestMapping("/SecureControllerB")
    public String helloSecureURL() {
	return "Accessed  !! SecureControllerB";
    }
}
