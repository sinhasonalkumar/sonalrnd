package com.sonal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Service2 {

    private static Logger log = LoggerFactory.getLogger(Service2.class);
    
    
    @Autowired
    private AuditService auditService;
    
    @Async
    public void service2Method(){
	log.info("Executing service1Method");
	auditService.doAudit();
    }
}
