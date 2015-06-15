package com.sonal.springrestsecurity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {

    private static Logger logger = LoggerFactory.getLogger(ServiceA.class);

    @Autowired
    private ServiceB serviceB;
    
    @Async
    public void serv() {
	logger.info("Serving A");
	serviceB.serv();
    }
}
