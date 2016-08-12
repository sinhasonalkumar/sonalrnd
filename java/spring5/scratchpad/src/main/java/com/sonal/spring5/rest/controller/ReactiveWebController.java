package com.sonal.spring5.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.spring5.rest.controller.vo.ReactiveWebResponseVO;
import com.sonal.spring5.rest.service.IHealthCheckService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactiveApp")
public class ReactiveWebController {

    static final Logger logger = LoggerFactory.getLogger(ReactiveWebController.class);

    @Autowired
    private IHealthCheckService healthCheckService;

    @GetMapping(value = "healthCheck", produces = "application/json")
    public Mono<ReactiveWebResponseVO> healthCheck() {
        
        return healthCheckService.inspectHealth();
    }

}
