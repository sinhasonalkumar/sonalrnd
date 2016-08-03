package com.sonal.streamncompfut.service;

import java.util.concurrent.CompletableFuture;

import com.sonal.streamncompfut.vo.ServiceRequestVO;
import com.sonal.streamncompfut.vo.ServiceResponseVO;

public class SampleService {

    public CompletableFuture<ServiceResponseVO> doSomething(ServiceRequestVO serviceRequestVO) {
	return CompletableFuture.supplyAsync(() -> processs(serviceRequestVO));
    }
    
    private ServiceResponseVO  processs(ServiceRequestVO serviceRequestVO){
	ServiceResponseVO serviceResponseVO = new ServiceResponseVO();
	System.out.println("Started");
	sleep(500);
	serviceResponseVO.setResult(serviceRequestVO.getInput() + " :: Proccessed");
	System.out.println("Completed");
	return serviceResponseVO;
    }
    
    private void sleep(long millis) {
	try {
	    Thread.sleep(millis);
	} catch (InterruptedException e) {
	    
	    e.printStackTrace();
	}
    }
}
