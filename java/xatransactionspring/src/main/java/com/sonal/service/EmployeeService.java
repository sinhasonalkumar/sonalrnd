package com.sonal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonal.components.IResourceManager;
import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.bo.EmployeeExpense;
import com.sonal.persistence.dao.IEmployeeDAO;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IResourceManager componentLocator;

    @Override
   
    @Transactional
    public List<Employee> getAllEmloyee() {

	List<Employee> employees = null;
	IEmployeeDAO employeeDAO = componentLocator.getDaoLocator().getEmployeeDAO();
	employees = employeeDAO.findAllEmployees();

	return employees;
    }

    @Override
    @Transactional
    public void saveEmployeesInBulk(Map<Employee, EmployeeExpense> employees) {
	IEmployeeDAO employeeDAO = componentLocator.getDaoLocator().getEmployeeDAO();
	EmployeeExpense employeeExpense = null;
	for (Employee employee : employees.keySet()) {
	    employeeExpense = employees.get(employee);
	    employeeDAO.saveEmployee(employee);
	}

    }
}
