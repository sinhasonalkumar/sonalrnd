package com.sonal.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    private static Logger log = LoggerFactory.getLogger(Service1.class);
    
    @Autowired
    private AuditService auditService;
    
    @Autowired
    private Service2 service2;
    
    @Autowired
    private Random random;
    
    @Async
    public void service1Method(){
	log.info("Executing service2Method");
	auditService.doAudit();
	
	sleepRandom();
	
	service2.service2Method();
	
    }
    
    
    private void sleepRandom() {
	try {
	    Thread.sleep(this.random.nextInt(1000));
	} catch (InterruptedException e) {
	    log.error("InterruptedException",e);
	}
    }
}
