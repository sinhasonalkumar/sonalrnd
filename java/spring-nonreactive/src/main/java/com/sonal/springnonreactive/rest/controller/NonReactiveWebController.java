package com.sonal.springnonreactive.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.springnonreactive.rest.controller.vo.NonReactiveWebRequestVO;
import com.sonal.springnonreactive.rest.controller.vo.ReactiveWebResponseVO;
import com.sonal.springnonreactive.rest.service.IHealthCheckService;
import com.sonal.springnonreactive.rest.service.IStudentService;

@RestController
@RequestMapping("/nonreactiveApp")
public class NonReactiveWebController {

    static final Logger logger = LoggerFactory.getLogger(NonReactiveWebController.class);

    @Autowired
    private IHealthCheckService healthCheckService;
    
    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "healthCheck", produces = "application/json")
    public ReactiveWebResponseVO healthCheck() {
	
        return healthCheckService.inspectHealth();
    }
    
    @PostMapping(value = "findStudent", consumes = "application/json",produces = "application/json")
    public ReactiveWebResponseVO findStudent(@RequestBody NonReactiveWebRequestVO reactiveWebRequestVO) {
        return studentService.findStudent(reactiveWebRequestVO.getUserName());
    }

}
