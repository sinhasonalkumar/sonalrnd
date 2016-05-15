package com.sonal.service;

import java.util.List;

import com.sonal.persistence.bo.EmployeeBO;

public interface IEmployeeService {

	List<EmployeeBO> getAllEmloyee();

	void saveEmployeesInBulk(List<EmployeeBO> employees);
	
	void saveOrUpdateEmployee(EmployeeBO employee);
	
	EmployeeBO findEmployeeByUserName(String userName);

	void deleteEmployee(EmployeeBO employee);

}
