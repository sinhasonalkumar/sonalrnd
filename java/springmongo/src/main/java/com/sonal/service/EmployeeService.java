package com.sonal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.dao.IEmployeeDAO;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public List<Employee> getAllEmloyee() {
		List<Employee> allEmployees = employeeDAO.findAll();
		return allEmployees;
	}

	@Override
	public void saveEmployeesInBulk(List<Employee> employees) {
		employeeDAO.save(employees);
	}

}
