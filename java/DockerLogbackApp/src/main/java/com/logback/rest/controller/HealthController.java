package com.logback.rest.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@ConditionalOnExpression(value = "${HealthController.enabled}")
public class HealthController {

    public final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @Autowired
    private ControllerDelegate controllerDelegate;
    
    @RequestMapping("/healthCheck")
    public DeferredResult<ResponseEntity<String>> healthCheck() {
	logger.info("Start healthCheck ... ");
	DeferredResult<ResponseEntity<String>> deferredHealthCheckResult = new DeferredResult<ResponseEntity<String>>();
	Map<String, String> mdcContext = MDC.getCopyOfContextMap();
	controllerDelegate.healthCheck(deferredHealthCheckResult, mdcContext);
	
	return deferredHealthCheckResult;
    }
    
}
