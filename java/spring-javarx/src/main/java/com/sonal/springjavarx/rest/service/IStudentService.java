package com.sonal.springjavarx.rest.service;

import com.sonal.springjavarx.rest.controller.vo.ReactiveWebResponseVO;

import rx.Observable;

public interface IStudentService {

    Observable<ReactiveWebResponseVO> findStudent(String userName);

}