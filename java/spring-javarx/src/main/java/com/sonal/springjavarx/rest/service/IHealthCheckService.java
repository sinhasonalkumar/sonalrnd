package com.sonal.springjavarx.rest.service;

import com.sonal.springjavarx.rest.controller.vo.ReactiveWebResponseVO;

import rx.Observable;

public interface IHealthCheckService {

    Observable<ReactiveWebResponseVO> inspectHealth();

}