package com.sonal.service;

import java.util.List;
import java.util.Map;

import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.bo.EmployeeExpense;

public interface IEmployeeService {

	List<Employee> getAllEmloyee();

	void saveEmployeesInBulk(Map<Employee, EmployeeExpense> employees);

}
