package com.sonal.springnonreactive.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.springnonreactive.rest.controller.vo.ReactiveWebResponseVO;
import com.sonal.springnonreactive.rest.dao.IStudentDAO;
import com.sonal.springnonreactive.rest.persistence.model.StudentBO;

@Service
public class StudentService implements IStudentService {

    static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    
    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public ReactiveWebResponseVO findStudent(String userName) {
	
	StudentBO studentBO = studentDAO.findByUserName(userName);
	
	String passportNo = this.getPassportFromPassportWebService(userName);
	
	return  convert(studentBO, passportNo);
		        
	
    }
    
    
    public String getPassportFromPassportWebService(String userName) {
	
	return dummyPassportWebService(userName);
    }
    
    public String dummyPassportWebService(String userName) {
	return userName.substring(0, 2) + "123";
    }
    
    
    public ReactiveWebResponseVO convert(StudentBO studentBO,String passportNo) {
	ReactiveWebResponseVO reactiveWebResponseVO = new ReactiveWebResponseVO();
	reactiveWebResponseVO.setStudent(studentBO);
	reactiveWebResponseVO.setPassportNo(passportNo);
	return reactiveWebResponseVO;
    }

}
