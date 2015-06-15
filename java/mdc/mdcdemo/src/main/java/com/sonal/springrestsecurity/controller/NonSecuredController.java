package com.sonal.springrestsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.springrestsecurity.controller.delegator.ControllerDelegator;

@RestController
public class NonSecuredController {
    
    private static Logger logger = LoggerFactory.getLogger(NonSecuredController.class);
    
    @Autowired
    private ControllerDelegator controllerDelegator;

    @RequestMapping("/NonSecuredController")
    public String helloNonSecuredURL() {
	
	logger.info("helloNonSecuredURL");
	
	controllerDelegator.delegateToService();
	
	String result = "Accessed  !! NonSecuredController";
	
	System.out.println(0/0);
	
	return result;
    }
}
