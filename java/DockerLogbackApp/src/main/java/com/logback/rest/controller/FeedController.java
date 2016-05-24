package com.logback.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class FeedController {

    @Autowired
    private ControllerDelegate controllerDelegate;

    @RequestMapping("/runFeed")
    public DeferredResult<ResponseEntity<String>> runFeed() {
	
	DeferredResult<ResponseEntity<String>> deferredHealthCheckResult = new DeferredResult<ResponseEntity<String>>();

	controllerDelegate.runFeed(deferredHealthCheckResult);

	return deferredHealthCheckResult;

    }
    
    @RequestMapping("/runFeedv2")
    public DeferredResult<ResponseEntity<String>> runFeedv2() {
	
	DeferredResult<ResponseEntity<String>> deferredHealthCheckResult = new DeferredResult<ResponseEntity<String>>();

	controllerDelegate.runFeedv2(deferredHealthCheckResult);

	return deferredHealthCheckResult;

    }
}
