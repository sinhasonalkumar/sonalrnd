package com.sonal.springrestsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @RequestMapping("/helloSecureURL")
    public String helloSecureURL() {
	return "helloSecureURL";
    }
}
