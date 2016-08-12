package com.sonal.spring5.rest.service;

import org.springframework.stereotype.Service;

import com.sonal.spring5.rest.controller.vo.ReactiveWebResponseVO;

import reactor.core.publisher.Mono;

@Service
public class HealthCheckService implements IHealthCheckService {

    @Override
    public  Mono<ReactiveWebResponseVO> inspectHealth() {
        ReactiveWebResponseVO reactiveWebResponseVO = new ReactiveWebResponseVO();
        reactiveWebResponseVO.setMessage("healthy");
        return Mono.just(reactiveWebResponseVO);
    }

}
