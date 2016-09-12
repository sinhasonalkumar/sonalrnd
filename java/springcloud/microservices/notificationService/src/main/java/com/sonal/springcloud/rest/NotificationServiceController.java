package com.sonal.springcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.sonal.springcloud.rest.vo.CoreServiceRequestVO;
import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;
import com.sonal.springcloud.service.INotificationService;
import com.sonal.springcloud.service.INotificationServiceHealthCheckService;

@RestController
@RequestMapping("/notificationService")
public class NotificationServiceController {

    @Autowired
    private INotificationServiceHealthCheckService coreServiceHealthCheckService;
    
    @Autowired
    private INotificationService notificationService;
    
    @RequestMapping(value = "/healthCheck",produces = "application/json")
    public DeferredResult<ResponseEntity<NotificationServiceResponseVO>> healthCheck(){
        
        DeferredResult<ResponseEntity<NotificationServiceResponseVO>> deferredResult = new DeferredResult<>();
        coreServiceHealthCheckService.checkHealth()
                                     .whenCompleteAsync((r,e) -> generateResponse(deferredResult, r, e));
        return deferredResult;
    }
    
    
    
    @RequestMapping(value = "/sendNotification",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public DeferredResult<ResponseEntity<NotificationServiceResponseVO>> findUser(@RequestBody CoreServiceRequestVO coreServiceRequestVO){
        
        DeferredResult<ResponseEntity<NotificationServiceResponseVO>> deferredResult = new DeferredResult<>();
        notificationService.sendNotification(coreServiceRequestVO.getUserName(), "Hello Spring Cloud World !!")
                                     .whenCompleteAsync((r,e) -> generateResponse(deferredResult, r, e));
        return deferredResult;
    }

    private void generateResponse(DeferredResult<ResponseEntity<NotificationServiceResponseVO>> deferredResult, NotificationServiceResponseVO r, Throwable e) {
        if(e == null ){
             ResponseEntity<NotificationServiceResponseVO> resp = new  ResponseEntity<>(r, HttpStatus.OK);
             deferredResult.setResult(resp);
         }else{
             ResponseEntity<NotificationServiceResponseVO> resp = new  ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
             deferredResult.setErrorResult(e);
             deferredResult.setResult(null);
         }
    }
}
