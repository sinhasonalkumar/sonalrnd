package com.sonal.websocket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sonal.websocket.rest.controller.vo.WebResponseVO;

import reactor.core.publisher.Mono;

@Service
public class HealthCheckService implements IHealthCheckService {

    static final Logger logger = LoggerFactory.getLogger(HealthCheckService.class);

    @Override
    public Mono<WebResponseVO> inspectHealth() {
       return Mono.create(t -> t.success(buildResp()));
    }

    private WebResponseVO buildResp() {
        WebResponseVO reactiveWebResponseVO = new WebResponseVO();
        reactiveWebResponseVO.setMessage("healthy");
        return reactiveWebResponseVO;
    }

}
