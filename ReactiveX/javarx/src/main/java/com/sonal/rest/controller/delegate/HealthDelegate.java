package com.sonal.rest.controller.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import com.sonal.rest.vo.BaseResponseVO;

@Component
public class HealthDelegate {
   
    @Async
    public void basicHealthCheck(DeferredResult<ResponseEntity<BaseResponseVO>> defResp) {
	
	BaseResponseVO baseResponseVO = new BaseResponseVO();
	baseResponseVO.setSuccess(true);
	baseResponseVO.setSuccessMesage("Healthy");
	baseResponseVO.setHttpStatus(HttpStatus.OK);
	
	
	ResponseEntity<BaseResponseVO> responseEntity = new ResponseEntity<>(baseResponseVO,HttpStatus.OK);
	
	defResp.setResult(responseEntity);
	
       
    }
}
