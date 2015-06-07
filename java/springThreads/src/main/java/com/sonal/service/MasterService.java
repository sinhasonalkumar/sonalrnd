package com.sonal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.context.ServiceRequestContext;
import com.sonal.context.ServiceRequestVO;

@Service
public class MasterService {

    @Autowired
    private ActualService actualService;

    @Autowired
    private StatusTrackerService statusTrackerService;

    public void kickOffProcess(ServiceRequestVO serviceRequestVO) {
	ServiceRequestContext.setServiceRequestVO(serviceRequestVO);
	System.out.println("RequestId :: " + ServiceRequestContext.getServiceRequestVO().getRequestId() + "Started");
	actualService.startLongRunningMethod();
	statusTrackerService.trackLongRunningService();
	while (!ServiceRequestContext.getServiceRequestVO().isDone()) {
	    
	}
	System.out.println("RequestId :: " + ServiceRequestContext.getServiceRequestVO().getRequestId() + " :: SuccessFully Completed !!");

    }
}
