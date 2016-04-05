package com.sonal.springrestsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredRestControllerB {

    @RequestMapping("/SecuredControllerB")
    public String helloSecuredOperation() {
	return "Accessed  !! SecureControllerB";
    }
}
