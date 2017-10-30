package com.sonal.spring5.springwebreactordemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.spring5.springwebreactordemo.controller.vo.StudentResponseVO;
import com.sonal.spring5.springwebreactordemo.persistence.bo.StudentBO;
import com.sonal.spring5.springwebreactordemo.persistence.dao.StudentDAO;

import reactor.core.publisher.Flux;

@Service
public class StudentService {
    
    @Autowired
    private StudentDAO studentDAO;

    public Flux<StudentResponseVO> findAllStudent(){
	return studentDAO.findAll()
			  .map(studentBO -> buildStudentResponseVO(studentBO));
    }
    
    private StudentResponseVO buildStudentResponseVO(StudentBO studentBO){
	StudentResponseVO studentResponseVO = new StudentResponseVO();
	studentResponseVO.setAge(studentBO.getAge());
	studentResponseVO.setName(studentBO.getName());
	return studentResponseVO;
	
    }
}
