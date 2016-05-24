package com.logback.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class PaymentController {

    @Autowired
    private ControllerDelegate controllerDelegate;
    
    @RequestMapping("/payment")
    public DeferredResult<ResponseEntity<String>> healthCheck() {
	
	DeferredResult<ResponseEntity<String>> deferredHealthCheckResult = new DeferredResult<ResponseEntity<String>>();
	
	controllerDelegate.payment(deferredHealthCheckResult);
	
	return deferredHealthCheckResult;
    }
}
