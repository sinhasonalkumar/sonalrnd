package com.sonal.springcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.sonal.springcloud.rest.vo.SampleNotificationServiceRequestVO;
import com.sonal.springcloud.rest.vo.SampleNotificationServiceResponseVO;
import com.sonal.springcloud.service.ISampleNotificationService;
import com.sonal.springcloud.service.ISampleNotificationServiceHealthCheckService;

@RestController
@RequestMapping("/sampleNotificationService")
public class SampleNotificationServiceController {

    @Autowired
    private ISampleNotificationServiceHealthCheckService coreServiceHealthCheckService;
    
    @Autowired
    private ISampleNotificationService notificationService;
    
    @RequestMapping(value = "/healthCheck",method = RequestMethod.GET,produces = "application/json")
    public DeferredResult<ResponseEntity<SampleNotificationServiceResponseVO>> healthCheck(){
        
        DeferredResult<ResponseEntity<SampleNotificationServiceResponseVO>> deferredResult = new DeferredResult<>();
        coreServiceHealthCheckService.checkHealth()
                                     .whenCompleteAsync((r,e) -> generateResponse(deferredResult, r, e));
        return deferredResult;
    }
    
    
    @RequestMapping(value = "/sendNotification",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public DeferredResult<ResponseEntity<SampleNotificationServiceResponseVO>> sendNotification(@RequestBody SampleNotificationServiceRequestVO coreServiceRequestVO){
        
        DeferredResult<ResponseEntity<SampleNotificationServiceResponseVO>> deferredResult = new DeferredResult<>();
        notificationService.sendNotification(coreServiceRequestVO.getUserName())
                                     .whenCompleteAsync((r,e) -> generateResponse(deferredResult, r, e));
        return deferredResult;
    }
    

    private void generateResponse(DeferredResult<ResponseEntity<SampleNotificationServiceResponseVO>> deferredResult, SampleNotificationServiceResponseVO r, Throwable e) {
        if(e == null ){
             ResponseEntity<SampleNotificationServiceResponseVO> resp = new  ResponseEntity<>(r, HttpStatus.OK);
             deferredResult.setResult(resp);
         }else{
             ResponseEntity<SampleNotificationServiceResponseVO> resp = new  ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
             deferredResult.setErrorResult(e);
             deferredResult.setResult(null);
         }
    }
}
