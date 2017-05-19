package com.sonal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.service.AppService;

@RestController
public class AppController  {

    private static Logger log = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AppService appService;
    
    @RequestMapping("/")
    public String home() {
	log.info("Handling home");
	
	appService.doSomething();
	
	return "Hello World";
    }

}
