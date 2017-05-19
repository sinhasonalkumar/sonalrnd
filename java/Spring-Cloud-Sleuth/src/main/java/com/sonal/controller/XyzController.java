package com.sonal.controller;

import java.util.Random;
import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sonal.service.AppService;

@RestController
public class XyzController implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private static final Log log = LogFactory.getLog(XyzController.class);

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private Tracer tracer;
    
    @Autowired
    private SpanAccessor accessor;
    
    @Autowired
    private AppService appService;
    
    @Autowired
    private Random random;
    
    private int port;

    @RequestMapping("/home")
    public String hi() throws InterruptedException {
	Thread.sleep(this.random.nextInt(1000));
	log.info("Home page");
	String s = this.restTemplate.getForObject("http://localhost:" + this.port + "/hi2", String.class);
	return "hi/" + s;
    }

    @RequestMapping("/call")
    public Callable<String> call() {
	return new Callable<String>() {
	    @Override
	    public String call() throws Exception {
		int millis = XyzController.this.random.nextInt(1000);
		Thread.sleep(millis);
		XyzController.this.tracer.addTag("callable-sleep-millis", String.valueOf(millis));
		Span currentSpan = XyzController.this.accessor.getCurrentSpan();
		return "async hi: " + currentSpan;
	    }
	};
    }

    @RequestMapping("/async")
    public String async() throws InterruptedException {
	log.info("async");
	appService.doSomething();
	return "ho";
    }

    @RequestMapping("/hi2")
    public String hi2() throws InterruptedException {
	log.info("hi2");
	int millis = this.random.nextInt(1000);
	Thread.sleep(millis);
	this.tracer.addTag("random-sleep-millis(Time-Consumed)", String.valueOf(millis));
	return "hi2";
    }

    @RequestMapping("/traced")
    public String traced() throws InterruptedException {
	Span span = this.tracer.createSpan("http:customTraceEndpoint", new AlwaysSampler());
	int millis = this.random.nextInt(1000);
	log.info(String.format("Sleeping for [%d] millis", millis));
	Thread.sleep(millis);
	this.tracer.addTag("random-sleep-millis(Time-Consumed)", String.valueOf(millis));

	String s = this.restTemplate.getForObject("http://localhost:" + this.port + "/call", String.class);
	this.tracer.close(span);
	return "traced/" + s;
    }

    @RequestMapping("/start")
    public String start() throws InterruptedException {
	int millis = this.random.nextInt(1000);
	log.info(String.format("Sleeping for [%d] millis", millis));
	Thread.sleep(millis);
	this.tracer.addTag("random-sleep-millis(Time-Consumed)", String.valueOf(millis));

	String s = this.restTemplate.getForObject("http://localhost:" + this.port + "/call", String.class);
	return "start/" + s;
    }

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
	this.port = event.getEmbeddedServletContainer().getPort();
    }

}
