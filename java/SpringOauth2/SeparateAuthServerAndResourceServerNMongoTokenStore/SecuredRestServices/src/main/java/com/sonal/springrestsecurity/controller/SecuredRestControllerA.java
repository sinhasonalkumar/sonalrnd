package com.sonal.springrestsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredRestControllerA {

    @RequestMapping("/SecuredControllerA")
    public String helloSecuredOperation() {
	return "Accessed  !! SecureControllerA";
    }
}
