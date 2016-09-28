package com.sonal.springnonreactive.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sonal.springnonreactive.rest.controller.vo.ReactiveWebResponseVO;

@Service
public class HealthCheckService implements IHealthCheckService {

    static final Logger logger = LoggerFactory.getLogger(HealthCheckService.class);

    @Override
    public ReactiveWebResponseVO inspectHealth() {
       return buildResp();
    }

    private ReactiveWebResponseVO buildResp() {
        ReactiveWebResponseVO reactiveWebResponseVO = new ReactiveWebResponseVO();
        reactiveWebResponseVO.setMessage("healthy");
        return reactiveWebResponseVO;
    }

}
