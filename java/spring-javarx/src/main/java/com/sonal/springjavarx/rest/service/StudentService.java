package com.sonal.springjavarx.rest.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.springjavarx.rest.controller.vo.ReactiveWebResponseVO;
import com.sonal.springjavarx.rest.dao.IStudentDAO;
import com.sonal.springjavarx.rest.dao.StudentDAO;
import com.sonal.springjavarx.rest.persistence.model.StudentBO;

import rx.Observable;

@Service
public class StudentService implements IStudentService {

    static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    
    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public Observable<ReactiveWebResponseVO> findStudent(String userName) {
	
	Observable<StudentBO> studentObservable = studentDAO.findByUserName(userName);
	
	Observable<String> studentPassportObservable = this.getPassportFromPassportWebService(userName);
	
	//return Observable.zip(studentObservable, studentPassportObservable, (studentBO,passportNo) -> convert(studentBO,passportNo));
	return Observable.zip(studentObservable, studentPassportObservable, this :: convert);
		        
	
    }
    
    
    public Observable<String> getPassportFromPassportWebService(String userName) {
	Observable<String> passportWebServiceObservable = Observable.create(sub -> {
	    
	    try {
		sub.onNext(dummyPassportWebService(userName));
		sub.onCompleted();
	    } catch (Exception e) {
		sub.onError(e);
	    }
	});
	passportWebServiceObservable.doOnSubscribe(() -> logger.info( "doOnSubscribe :: Subscribed :: Service :: dummyPassportWebService :: UserName -> " + userName))
				  //.doOnRequest(t ->) handle backPressure
				    .doOnCompleted(() -> logger.info( "doOnCompleted :: Passport Found From dummyPassportWebService :: UserName -> " + userName))
				    .doOnError(t -> logger.info( "doOnError :: Error While Finding Passport From  dummyPassportWebService :: UserName -> " + userName,t))
				    .doOnUnsubscribe(() -> logger.info( "doOnUnsubscribe :: UnSubscribed :: Service :: dummyPassportWebService :: UserName -> " + userName));
	
	return passportWebServiceObservable;
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
