package com.sonal.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private static Logger log = LoggerFactory.getLogger(AppService.class);

    @Autowired
    private Random random;
    
    @Autowired
    private AuditService auditService;
    
    @Autowired
    private Service1 service1;
    
    @Autowired
    private Service2 service2;

    public void doSomething() {
	log.info("Doing Something");
	
	auditService.doAudit();
	
	sleepRandom();
	
	service1.service1Method();
	
	sleepRandom();
	
	service2.service2Method();
    }
    
    private void sleepRandom() {
	try {
	    Thread.sleep(this.random.nextInt(3000));
	} catch (InterruptedException e) {
	    log.error("InterruptedException",e);
	}
    }
}
