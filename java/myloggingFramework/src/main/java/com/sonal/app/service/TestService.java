package com.sonal.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sonal.app.dao.TestDAO;
import com.sonal.app.persistence.entity.Employee;

@Component
public class TestService {
	
	@Autowired
	private TestDAO testDAO;
	
	@Autowired
	private TestAsyncService testAsyncService;

	@Transactional
	public List<Employee> getAllEMployees() throws Exception{
		List<Employee> employees = testDAO.getAllEMployees();
		doSomething();
		for(int i=0 ; i<2; i++){
			testAsyncService.doSomethingAsync();
			Thread.sleep(1000);
		}
		
		return employees;
	}

	@Transactional
	public Employee createEmployee(Employee emp) {
		   testDAO.createEmployee(emp);
		return emp;
	}
	
	private void doSomething() throws Exception{
		System.out.println("Doing Something....");
	}
}
