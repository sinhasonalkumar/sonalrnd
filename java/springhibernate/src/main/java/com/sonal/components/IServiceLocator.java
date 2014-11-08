package com.sonal.components;

import com.sonal.service.IEmployeeService;
import com.sonal.service.async.IAsyncService;


public interface IServiceLocator {

	IEmployeeService getEmployeeService();

	IAsyncService getAsyncService();

}
