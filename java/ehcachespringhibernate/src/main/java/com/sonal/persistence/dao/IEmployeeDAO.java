package com.sonal.persistence.dao;

import java.util.List;

import com.sonal.persistence.bo.Employee;

public interface IEmployeeDAO {

	List<Employee> findAllEmployees();

	void saveEmployee(Employee employee);

}
