package com.sonal.springnonreactive.rest.service;

import com.sonal.springnonreactive.rest.controller.vo.ReactiveWebResponseVO;

public interface IHealthCheckService {

    ReactiveWebResponseVO inspectHealth();

}