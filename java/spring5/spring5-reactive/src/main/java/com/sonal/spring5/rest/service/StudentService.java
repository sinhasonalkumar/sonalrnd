package com.sonal.spring5.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.spring5.rest.controller.vo.ReactiveWebResponseVO;
import com.sonal.spring5.rest.dao.IStudentDAO;
import com.sonal.spring5.rest.persistence.model.StudentBO;

import reactor.core.publisher.Mono;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public Mono<ReactiveWebResponseVO> findStudent(String userName) {
	
	return studentDAO.findByUserName(userName)
		         .map(this :: convert);
	
    }

    public ReactiveWebResponseVO convert(StudentBO studentBO) {
	ReactiveWebResponseVO reactiveWebResponseVO = new ReactiveWebResponseVO();
	reactiveWebResponseVO.setStudent(studentBO);
	return reactiveWebResponseVO;
    }

}
