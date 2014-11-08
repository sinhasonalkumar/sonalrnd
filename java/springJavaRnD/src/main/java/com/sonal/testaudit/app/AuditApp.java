package com.sonal.testaudit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.testaudit.services.Service1;
import com.sonal.testaudit.services.Service2;

@Service
public class AuditApp {

	@Autowired
	private Service1 service1;
	
	@Autowired
	private Service2 service2;
	
	public void complexActivity(){
		service1.activity1();
		service2.activity2();
	}
}
