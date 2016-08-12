package com.sonal.spring5.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sonal.spring5.rest.persistence.model.StudentBO;

import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoProcessor;

@Component
public class StudentDAO implements IStudentDAO {

    static final Logger logger = LoggerFactory.getLogger(StudentDAO.class);
    
    @Override
    public Mono<List<StudentBO>> findAll() {

	List<StudentBO> students = executeQuery();
	
	return Mono.just(students);
    }

    @Override
    public Mono<StudentBO> findByUserName(String userName) {
	
	MonoProcessor<StudentBO> studentBOMonoProcessor = MonoProcessor.create();
	
	studentBOMonoProcessor.doOnSuccess(s -> logger.info( "doOnSuccess :: Student Found In DB :: UserName -> " + s.getUserName()) )
	                      .doOnError(t -> logger.info( "doOnError :: Error While Finding User In DB  -> " + t.getMessage(),t))
	                      .doOnTerminate((s,t) -> logger.info( "doOnTerminate :: Student Found In DB :: UserName -> " + s.getUserName()))
	                      .subscribe();
	
	
	studentBOMonoProcessor.onNext(executeQuery(userName));
	
	return studentBOMonoProcessor;
    }
    
    
   /* // Other way to getting Mono
    @Override
    public Mono<StudentBO> findByUserName(String userName) {
	
	StudentBO student = executeQuery(userName);
	return Mono.just(student);
    }*/
    
    

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
