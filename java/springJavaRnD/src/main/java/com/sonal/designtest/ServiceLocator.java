package com.sonal.designtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocator implements IServiceLocator{

	@Autowired
	private IService service;

	public IService getService() {
		return service;
	}
	
	
}
