package com.sonal.app.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.app.service.external.ExternalService;
import com.sonal.util.annotation.HandleException;

@Service
public class InternalService {
	
	@Autowired
	private ExternalService externalService;

	@HandleException(clazz = InternalService.class,errorCode = "INT_01",errorMessage = "callInternalService Failed",exceptionType = "InternalException")
	public void callInternalService() throws Throwable {
		externalService.callExternalService();
		//System.out.println(0/0);
	}
}
