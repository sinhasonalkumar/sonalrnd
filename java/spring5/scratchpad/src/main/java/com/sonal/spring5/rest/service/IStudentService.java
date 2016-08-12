package com.sonal.spring5.rest.service;

import com.sonal.spring5.rest.controller.vo.ReactiveWebResponseVO;

import reactor.core.publisher.Mono;

public interface IStudentService {

    Mono<ReactiveWebResponseVO> findStudent(String userName);

}