package com.sonal.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sonal.context.ServiceRequestContext;

@Service
public class ActualService {

    @Async
    public void startLongRunningMethod() {
	
	for (int i = 1; i <= 100; i++) {
	    ServiceRequestContext.getServiceRequestVO().setProgress(i);
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		
	    }
	}
    }
}
