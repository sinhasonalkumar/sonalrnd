package com.sonal.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/health")
public class HealthCheckController {

    @RequestMapping("/check")
    public String healthCheck() {
	return "Up";
    }
}
