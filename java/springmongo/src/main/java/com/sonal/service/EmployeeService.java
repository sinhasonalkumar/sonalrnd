package com.sonal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sonal.persistence.bo.EmployeeBO;
import com.sonal.persistence.dao.IEmployeeDAO;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public List<EmployeeBO> getAllEmloyee() {
		List<EmployeeBO> allEmployees = employeeDAO.findAll();
		return allEmployees;
	}

	@Override
	public void saveEmployeesInBulk(List<EmployeeBO> employees) {
		employeeDAO.insert(employees);
	}

	@Override
	public void saveOrUpdateEmployee(EmployeeBO employee) {
	    employeeDAO.save(employee);
	    
	}
	
	@Override
	public void deleteEmployee(EmployeeBO employee){
	    employeeDAO.delete(employee);
	}

	
	@Override
	public EmployeeBO findEmployeeByUserName(String userName) {
	    EmployeeBO employee = null;
	    List<EmployeeBO> employeees = employeeDAO.findByuserName(userName);
	    if(!CollectionUtils.isEmpty(employeees)){
		employee = employeees.get(0);
	    }
	    return employee;
	}
	
	
	 

}
