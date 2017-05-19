package com.sonal.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    private static Logger log = LoggerFactory.getLogger(AuditService.class);
    
    @Autowired
    private Random random;
    
    @Async
    public void doAudit(){
	log.info("Doing Auditing");
	sleepRandom();
	
    }

    private void sleepRandom() {
	try {
	    Thread.sleep(this.random.nextInt(1000));
	} catch (InterruptedException e) {
	    log.error("InterruptedException",e);
	}
    }
}
