package com.sonal.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.sonal.rest.controller.delegate.GatewayDeviceDelegate;
import com.sonal.service.vo.CustomerDeviceInfoVO;

@RestController
@RequestMapping("/gateway")
public class GatewayDeviceController {

    @Autowired
    private GatewayDeviceDelegate gatewayDeviceDelegate;
    
    @RequestMapping(value="/customerDeviceInfo/{customerId}")
    public DeferredResult<ResponseEntity<CustomerDeviceInfoVO>> showCustomerDeviceInfo(@PathVariable("customerId") String customerId) {
	
	DeferredResult<ResponseEntity<CustomerDeviceInfoVO>> defResp = new DeferredResult<ResponseEntity<CustomerDeviceInfoVO>>();
	gatewayDeviceDelegate.showCustomerDeviceInfo(defResp,customerId);
        
	return defResp;
    }
}
