package com.sonal.springrestsecurity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceC {

    private static Logger logger = LoggerFactory.getLogger(ServiceC.class);

    @Async
    public void serv() {
	logger.info("Serving C");
	throw new RuntimeException("Service C went Bad !!");
    }
}
