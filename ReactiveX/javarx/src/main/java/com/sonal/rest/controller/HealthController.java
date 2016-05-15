package com.sonal.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.sonal.rest.controller.delegate.HealthDelegate;
import com.sonal.rest.vo.BaseResponseVO;

@RestController
@RequestMapping("/health")
public class HealthController {
    
    @Autowired
    private HealthDelegate healthDelegate;
    
    @RequestMapping(value="/check")
    public DeferredResult<ResponseEntity<BaseResponseVO>> basicHealthCheck() {
	
	DeferredResult<ResponseEntity<BaseResponseVO>> defResp = new DeferredResult<ResponseEntity<BaseResponseVO>>();
	healthDelegate.basicHealthCheck(defResp);
        
	return defResp;
    }
}
