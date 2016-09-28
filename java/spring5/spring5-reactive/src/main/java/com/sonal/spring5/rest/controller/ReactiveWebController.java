package com.sonal.spring5.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.spring5.rest.controller.vo.ReactiveWebRequestVO;
import com.sonal.spring5.rest.controller.vo.ReactiveWebResponseVO;
import com.sonal.spring5.rest.service.IHealthCheckService;
import com.sonal.spring5.rest.service.IStudentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactiveApp")
public class ReactiveWebController {

    static final Logger logger = LoggerFactory.getLogger(ReactiveWebController.class);

    @Autowired
    private IHealthCheckService healthCheckService;
    
    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "healthCheck", produces = "application/json")
    public Mono<ReactiveWebResponseVO> healthCheck() {
        
        return healthCheckService.inspectHealth();
    }
    
    @PostMapping(value = "findStudent", consumes = "application/json",produces = "application/json")
    public Mono<ReactiveWebResponseVO> findStudent(@RequestBody ReactiveWebRequestVO reactiveWebRequestVO) {
        
        return studentService.findStudent(reactiveWebRequestVO.getUserName());
    }

}
