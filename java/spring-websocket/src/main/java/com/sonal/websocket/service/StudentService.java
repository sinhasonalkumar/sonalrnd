package com.sonal.websocket.service;

import org.springframework.stereotype.Service;

import com.sonal.websocket.rest.controller.vo.WebResponseVO;

import reactor.core.publisher.Mono;

@Service
public class StudentService implements IStudentService {


    @Override
    public Mono<WebResponseVO> findStudent(String userName) {
	
	return Mono.just(build(userName));
	
    }

    public WebResponseVO build(String userName) {
	WebResponseVO reactiveWebResponseVO = new WebResponseVO();
	reactiveWebResponseVO.setMessage("Hello " + userName + "!!");
	return reactiveWebResponseVO;
    }

}
