package com.sonal.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sonal.context.ServiceRequestContext;

@Service
public class StatusTrackerService {

    @Async
    public void trackLongRunningService() {
	while (ServiceRequestContext.getServiceRequestVO().getProgress() <= 100) {
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {

	    }
	    System.out.println("Request Id :: " + ServiceRequestContext.getServiceRequestVO().getRequestId() + " :: Progress :: " + ServiceRequestContext.getServiceRequestVO().getProgress() + " %");

	    if (ServiceRequestContext.getServiceRequestVO().getProgress() == 100) {
		System.out.println("Request Id :: " + ServiceRequestContext.getServiceRequestVO().getRequestId() + "Progress :: 100 %");
		ServiceRequestContext.getServiceRequestVO().setDone(true);
		break;
	    }
	}

    }
}
