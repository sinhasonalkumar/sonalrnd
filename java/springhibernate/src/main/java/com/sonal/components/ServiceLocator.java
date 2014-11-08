package com.sonal.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.service.IEmployeeService;

@Component
public class ServiceLocator implements IServiceLocator{

	@Autowired
	private IEmployeeService employeeService;

	@Override
	public IEmployeeService getEmployeeService() {
		return employeeService;
	}
	
	
}
