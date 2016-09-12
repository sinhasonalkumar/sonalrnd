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
import com.sonal.springcloud.rest.vo.CoreServiceResponseVO;
import com.sonal.springcloud.service.ICoreService;
import com.sonal.springcloud.service.ICoreServiceHealthCheckService;

@RestController
@RequestMapping("/coreService")
public class CoreServiceController {

    @Autowired
    private ICoreServiceHealthCheckService coreServiceHealthCheckService;
    
    @Autowired
    private ICoreService coreService;
    
    @RequestMapping(value = "/healthCheck",method = RequestMethod.GET,produces = "application/json")
    public DeferredResult<ResponseEntity<CoreServiceResponseVO>> healthCheck(){
        
        DeferredResult<ResponseEntity<CoreServiceResponseVO>> deferredResult = new DeferredResult<>();
        coreServiceHealthCheckService.checkHealth()
                                     .whenCompleteAsync((r,e) -> generateResponse(deferredResult, r, e));
        return deferredResult;
    }
    
    
    @RequestMapping(value = "/findUser",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public DeferredResult<ResponseEntity<CoreServiceResponseVO>> findUser(@RequestBody CoreServiceRequestVO coreServiceRequestVO){
        
        DeferredResult<ResponseEntity<CoreServiceResponseVO>> deferredResult = new DeferredResult<>();
        coreService.findUserInfo(coreServiceRequestVO.getUserName())
                                     .whenCompleteAsync((r,e) -> generateResponse(deferredResult, r, e));
        return deferredResult;
    }
    

    private void generateResponse(DeferredResult<ResponseEntity<CoreServiceResponseVO>> deferredResult, CoreServiceResponseVO r, Throwable e) {
        if(e == null ){
             ResponseEntity<CoreServiceResponseVO> resp = new  ResponseEntity<>(r, HttpStatus.OK);
             deferredResult.setResult(resp);
         }else{
             ResponseEntity<CoreServiceResponseVO> resp = new  ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
             deferredResult.setErrorResult(e);
             deferredResult.setResult(null);
         }
    }
}
