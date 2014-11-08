package com.sonal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.components.IComponentLocator;
import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.dao.IEmployeeDAO;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IComponentLocator componentLocator;

	@Override
	public List<Employee> getAllEmloyee() {

		List<Employee> employees = null;
		IEmployeeDAO employeeDAO = componentLocator.getDaoLocator().getEmployeeDAO();
		employees = employeeDAO.findAllEmployees();

		return employees;
	}
}
