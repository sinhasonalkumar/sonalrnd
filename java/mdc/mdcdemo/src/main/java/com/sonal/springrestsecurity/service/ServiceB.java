package com.sonal.springrestsecurity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    private static Logger logger = LoggerFactory.getLogger(ServiceB.class);

    @Autowired
    private ServiceC serviceC;
    
    @Async
    public void serv() {
	logger.info("Serving B");
	serviceC.serv();
    }
}
