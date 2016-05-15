package com.sonal.rest.controller.delegate;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import com.sonal.rest.vo.DeviceResponseVO;
import com.sonal.service.IGatewayDeviceService;
import com.sonal.service.vo.CustomerDeviceInfoVO;

@Component
public class GatewayDeviceDelegate {

    @Autowired
    private IGatewayDeviceService gatewayDeviceService;
    
    @Async
    public void showCustomerDeviceInfo(DeferredResult<ResponseEntity<CustomerDeviceInfoVO>> defResp, String customerId) {
	
	CompletableFuture<CustomerDeviceInfoVO> customerDeviceInfoFuture = gatewayDeviceService.findCustomerDeviceInfoAsync(customerId);
	
	customerDeviceInfoFuture.whenComplete((customerDeviceInfo,throwable) -> {
	    if(throwable == null){
		DeviceResponseVO deviceResponseVO = new DeviceResponseVO();
		deviceResponseVO.setCustomerDeviceInfo(customerDeviceInfo);
		
		ResponseEntity<CustomerDeviceInfoVO> responseEntity = new ResponseEntity<CustomerDeviceInfoVO>(customerDeviceInfo,HttpStatus.OK);
		
		defResp.setResult(responseEntity);
	    }else{
		defResp.setErrorResult(throwable.toString());
	    }
	    	
	});
	
	
	
    }

}
