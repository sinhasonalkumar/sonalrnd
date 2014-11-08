package com.sonal.app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sonal.app.service.internal.InternalService;
import com.sonal.util.annotation.HandleException;
import com.sonal.util.annotation.MapException;

@Component
public class MainClass {
	

	
	public static void main(String[] args) throws Throwable{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MainClass main = appContext.getBean(MainClass.class);
		main.call(appContext);
		
	}
	
	@MapException
	@HandleException(clazz = InternalService.class,errorCode = "INT_01",errorMessage = "callInternalService Failed",exceptionType = "InternalException")
	public void call(ApplicationContext appContext) throws Throwable{
		
		InternalService internalService = appContext.getBean(InternalService.class);
		internalService.callInternalService();
	}
}
