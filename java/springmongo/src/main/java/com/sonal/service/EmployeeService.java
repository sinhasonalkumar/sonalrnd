package com.sonal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
	    employeeDAO.save(employee);
	    
	}
	
	@Override
	public void deleteEmployee(Employee employee){
	    employeeDAO.delete(employee);
	}

	
	@Override
	public Employee findEmployeeByUserName(String userName) {
	    Employee employee = null;
	    List<Employee> employeees = employeeDAO.findByuserName(userName);
	    if(!CollectionUtils.isEmpty(employeees)){
		employee = employeees.get(0);
	    }
	    return employee;
	}
	
	
	 

}
