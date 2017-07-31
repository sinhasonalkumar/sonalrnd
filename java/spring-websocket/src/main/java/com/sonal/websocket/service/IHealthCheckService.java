package com.sonal.websocket.service;



import com.sonal.websocket.rest.controller.vo.WebResponseVO;

import reactor.core.publisher.Mono;

public interface IHealthCheckService {

    Mono<WebResponseVO> inspectHealth();

}