package com.sonal.components;

import com.sonal.service.IEmployeeService;


public interface IServiceLocator {

	IEmployeeService getEmployeeService();

}
