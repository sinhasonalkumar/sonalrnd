package com.sonal.springjavarx.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sonal.springjavarx.rest.persistence.model.StudentBO;

import rx.Observable;

@Component
public class StudentDAO implements IStudentDAO {

    static final Logger logger = LoggerFactory.getLogger(StudentDAO.class);
    
    @Override
    public Observable<List<StudentBO>> findAll() {

	List<StudentBO> students = executeQuery();
	
	return Observable.just(students);
    }

    @Override
    public Observable<StudentBO> findByUserName(String userName) {
	
	Observable<StudentBO> studentBOObservable = Observable.create(sub -> {
	    
	    try {
		sub.onNext(executeQuery(userName));
		sub.onCompleted();
	    } catch (Throwable e) {
		sub.onError(e);
	    }
	});
	
	// Side Effect Methods 
	studentBOObservable.doOnSubscribe(() -> logger.info( "doOnSubscribe :: Subscribed :: DAO :: findByUserName :: UserName -> " + userName))
			   //.doOnRequest(t ->) handle backPressure
			   .doOnCompleted(() -> logger.info( "doOnCompleted :: Student Found In DB :: UserName -> " + userName))
			   .doOnError(t -> logger.info( "doOnError :: Error While Findig Student From DB :: UserName -> " + userName,t))
			   .doOnUnsubscribe(() -> logger.info( "doOnUnsubscribe :: UnSubscribed :: DAO :: findByUserName :: UserName -> " + userName));
	
	
	return studentBOObservable;
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
