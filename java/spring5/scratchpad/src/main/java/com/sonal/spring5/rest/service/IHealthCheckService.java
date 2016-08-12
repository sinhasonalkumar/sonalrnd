package com.sonal.spring5.rest.service;

import com.sonal.spring5.rest.controller.vo.ReactiveWebResponseVO;

import reactor.core.publisher.Mono;

public interface IHealthCheckService {

    Mono<ReactiveWebResponseVO> inspectHealth();

}