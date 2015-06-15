package com.sonal.springrestsecurity.controller.delegator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.springrestsecurity.service.ServiceA;

@Service
public class ControllerDelegator {

    private static Logger logger = LoggerFactory.getLogger(ControllerDelegator.class);

    @Autowired
    private ServiceA serviceA;

    public void delegateToService() {
	logger.info("delegateToService");
	serviceA.serv();
    }
}
