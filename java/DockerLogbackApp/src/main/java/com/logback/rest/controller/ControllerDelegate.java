package com.logback.rest.controller;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import com.logback.service.FeedProcessorService;

@Component
public class ControllerDelegate {

    public final Logger logger = LoggerFactory.getLogger(ControllerDelegate.class);

    @Autowired
    private FeedProcessorService feedProcessorService;

    @Async("threadPoolTaskExecutor")
    public void healthCheck(DeferredResult<ResponseEntity<String>> deferredHealthCheckResult, Map<String, String> mdcContext) {
	//MDC.setContextMap(mdcContext);
	logger.info("Start healthCheck ... ");
	String response = new String("Healthy");

	Runtime runtime = Runtime.getRuntime();
	final NumberFormat format = NumberFormat.getInstance();
	final long maxMemory = runtime.maxMemory();
	final long allocatedMemory = runtime.totalMemory();
	final long freeMemory = runtime.freeMemory();
	final long mb = 1024 * 1024;
	final String megaByte = "MB";

	StringBuffer memDetails = new StringBuffer();

	memDetails.append(" :: Free memory: " + format.format(freeMemory / mb) + megaByte);
	memDetails.append(" :: Allocated memory: " + format.format(allocatedMemory / mb) + megaByte);
	memDetails.append(" :: Max memory: " + format.format(maxMemory / mb) + megaByte);
	memDetails.append(" :: Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + megaByte);

	logger.info(memDetails.toString());

	response = response + " ::  " + memDetails.toString();

	ResponseEntity<String> healthCheckResponseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
	deferredHealthCheckResult.setResult(healthCheckResponseEntity);
	logger.info("End healthCheck ...");
    }

    @Async
    public void payment(DeferredResult<ResponseEntity<String>> deferredHealthCheckResult) {

	String response = new String("Payment Successful !!");

	ResponseEntity<String> healthCheckResponseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
	deferredHealthCheckResult.setResult(healthCheckResponseEntity);

    }

    @Async
    public void runFeed(DeferredResult<ResponseEntity<String>> deferredHealthCheckResult) {
	String processFeed = feedProcessorService.processFeed();
	ResponseEntity<String> healthCheckResponseEntity = new ResponseEntity<String>(processFeed, HttpStatus.OK);
	deferredHealthCheckResult.setResult(healthCheckResponseEntity);
    }

    @Async
    public void runFeedv2(DeferredResult<ResponseEntity<String>> deferredHealthCheckResult) {
	String processFeed = feedProcessorService.processFeed();
	ResponseEntity<String> healthCheckResponseEntity = new ResponseEntity<String>(processFeed, HttpStatus.OK);
	deferredHealthCheckResult.setResult(healthCheckResponseEntity);
    }

    @Async
    public void healthCheckNotification(DeferredResult<ResponseEntity<String>> deferredHealthCheckResult) {
	while (true) {
	    logger.info("Start healthCheck ... ");
	    String response = new String("Healthy");

	    Runtime runtime = Runtime.getRuntime();
	    final NumberFormat format = NumberFormat.getInstance();
	    final long maxMemory = runtime.maxMemory();
	    final long allocatedMemory = runtime.totalMemory();
	    final long freeMemory = runtime.freeMemory();
	    final long mb = 1024 * 1024;
	    final String megaByte = "MB";

	    StringBuffer memDetails = new StringBuffer();

	    memDetails.append(" :: Time :: " + new Date());
	    memDetails.append(" :: Free memory: " + format.format(freeMemory / mb) + megaByte);
	    memDetails.append(" :: Allocated memory: " + format.format(allocatedMemory / mb) + megaByte);
	    memDetails.append(" :: Max memory: " + format.format(maxMemory / mb) + megaByte);
	    memDetails.append(" :: Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + megaByte);

	    logger.info(memDetails.toString());

	    response = response + " ::  " + memDetails.toString();

	    ResponseEntity<String> healthCheckResponseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
	    deferredHealthCheckResult.setResult(healthCheckResponseEntity);
	    logger.info("End healthCheck ...");

	    try {
		Thread.sleep(1000l);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
