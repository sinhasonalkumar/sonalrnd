package com.sonal.service;

import java.util.List;

import com.sonal.persistence.bo.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmloyee();

	void saveEmployeesInBulk(List<Employee> employees);

	void saveEmployees(List<Employee> employees);

}
