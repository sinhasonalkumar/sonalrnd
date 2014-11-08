package com.sonal.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.service.IEmployeeService;
import com.sonal.service.async.IAsyncService;

@Component
public class ServiceLocator implements IServiceLocator{

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IAsyncService asyncService;

	@Override
	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	@Override
	public IAsyncService getAsyncService() {
		return asyncService;
	}
	
	
	
}
