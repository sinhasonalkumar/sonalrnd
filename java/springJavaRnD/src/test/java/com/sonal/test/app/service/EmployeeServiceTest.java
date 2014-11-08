package com.sonal.test.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.sonal.app.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testPrintAllAddress(){
		employeeService.printAllAddress();
	}
	
	@Test
	public void testPrintAllSKills(){
		employeeService.printAllSKills();
	}

}
