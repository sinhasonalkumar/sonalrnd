package com.sonal.completablefuture;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.sonal.streamncompfut.vo.ServiceRequestVO;
import com.sonal.streamncompfut.vo.ServiceResponseVO;

public class SomeNonBlockingService {

    public CompletableFuture<ServiceResponseVO> doSomethingStep1(ServiceRequestVO serviceRequestVO){
	ServiceResponseVO serviceResponseVO = new ServiceResponseVO();
	serviceResponseVO.setResult(serviceRequestVO.getInput() + " :: " + UUID.randomUUID());
	return CompletableFuture.supplyAsync(() -> serviceResponseVO);
    }
    
    public CompletableFuture<ServiceResponseVO> doSomethingStep2(ServiceRequestVO serviceRequestVO){
	ServiceResponseVO serviceResponseVO = new ServiceResponseVO();
	serviceResponseVO.setResult(serviceRequestVO.getInput() + " :: " + UUID.randomUUID());
	return CompletableFuture.supplyAsync(() -> serviceResponseVO);
    }
}
