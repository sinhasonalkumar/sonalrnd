package com.sonal.spring5.springwebreactordemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.spring5.springwebreactordemo.controller.vo.StudentResponseVO;
import com.sonal.spring5.springwebreactordemo.service.StudentService;

import reactor.core.publisher.Flux;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @GetMapping(value="/student/all")
    public Flux<StudentResponseVO> findAllStudents(){
	
	return studentService.findAllStudent();
    }
}
