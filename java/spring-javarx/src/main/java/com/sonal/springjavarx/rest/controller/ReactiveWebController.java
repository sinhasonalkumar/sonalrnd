package com.sonal.springjavarx.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.sonal.springjavarx.rest.controller.vo.ReactiveWebRequestVO;
import com.sonal.springjavarx.rest.controller.vo.ReactiveWebResponseVO;
import com.sonal.springjavarx.rest.service.IHealthCheckService;
import com.sonal.springjavarx.rest.service.IStudentService;

import rx.schedulers.Schedulers;

@RestController
@RequestMapping("/reactiveApp")
public class ReactiveWebController {

    static final Logger logger = LoggerFactory.getLogger(ReactiveWebController.class);

    @Autowired
    private IHealthCheckService healthCheckService;
    
    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "healthCheck", produces = "application/json")
    public DeferredResult<ReactiveWebResponseVO> healthCheck() {
        
	DeferredResult<ReactiveWebResponseVO> deferredResult = new DeferredResult<ReactiveWebResponseVO>();
	
	healthCheckService.inspectHealth()
			  .subscribeOn(Schedulers.io())
			  .subscribe(
				  	reactiveWebResponseVO -> deferredResult.setResult(reactiveWebResponseVO),
				  	error -> deferredResult.setErrorResult("Health Check Failed :: Error " + error)
				    );
	
	
        return deferredResult;
    }
    
    @PostMapping(value = "findStudent", consumes = "application/json",produces = "application/json")
    public DeferredResult<ReactiveWebResponseVO> findStudent(@RequestBody ReactiveWebRequestVO reactiveWebRequestVO) {
	
	DeferredResult<ReactiveWebResponseVO> deferredResult = new DeferredResult<ReactiveWebResponseVO>();
        
	studentService.findStudent(reactiveWebRequestVO.getUserName())
		      .subscribeOn(Schedulers.io())
		      .subscribe(
			      		reactiveWebResponseVO -> deferredResult.setResult(reactiveWebResponseVO),
			      		error -> deferredResult.setErrorResult("findStudent Failed :: Error " + error)
			      	);
	
        return deferredResult;
    }

}
