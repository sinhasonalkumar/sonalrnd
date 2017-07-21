package com.sonal.completablefuture;

import java.util.UUID;

import com.sonal.streamncompfut.vo.ServiceRequestVO;
import com.sonal.streamncompfut.vo.ServiceResponseVO;

public class SomeBlockingService {

    public ServiceResponseVO doSomethingStep1(ServiceRequestVO serviceRequestVO){
	ServiceResponseVO serviceResponseVO = new ServiceResponseVO();
	serviceResponseVO.setResult(serviceRequestVO.getInput() + " :: " + UUID.randomUUID());
	return serviceResponseVO;
    }
    
    public ServiceResponseVO doSomethingStep2(ServiceRequestVO serviceRequestVO){
	ServiceResponseVO serviceResponseVO = new ServiceResponseVO();
	serviceResponseVO.setResult(serviceRequestVO.getInput() + " :: " + UUID.randomUUID());
	return serviceResponseVO;
    }
}
