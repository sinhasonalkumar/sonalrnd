package com.sonal.app.service.external;

import org.springframework.stereotype.Service;

import com.sonal.util.annotation.HandleException;

@Service
public class ExternalService {

	@HandleException(clazz = ExternalService.class,errorCode = "EXT_01",errorMessage = "callInternalService Failed",exceptionType = "ExternalException")
	public void callExternalService() throws Throwable {
		System.out.println(0/0);
	}
}
