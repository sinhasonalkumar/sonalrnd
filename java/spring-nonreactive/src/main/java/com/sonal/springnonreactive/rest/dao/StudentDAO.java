package com.sonal.springnonreactive.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sonal.springnonreactive.rest.persistence.model.StudentBO;

@Component
public class StudentDAO implements IStudentDAO {

    static final Logger logger = LoggerFactory.getLogger(StudentDAO.class);
    
    @Override
    public List<StudentBO> findAll() {

	List<StudentBO> students = executeQuery();
	
	return students;
    }

    @Override
    public StudentBO findByUserName(String userName) {
	
	return executeQuery(userName);
    }
    

    private StudentBO executeQuery(String userName) {
	StudentBO student = new StudentBO();
	student.setUserName(userName);
	return student;
    }
    
    private List<StudentBO> executeQuery() {
	
	List<StudentBO> students = new ArrayList<>();
	StudentBO student = new StudentBO();
	student.setUserName("abc");
	students.add(student);
	
	return students;
    }
}
