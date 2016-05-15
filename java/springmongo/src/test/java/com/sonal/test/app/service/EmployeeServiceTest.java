package com.sonal.test.app.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.annotation.Version;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.sonal.config.AppConfig;
import com.sonal.persistence.bo.EmployeeBO;
import com.sonal.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class EmployeeServiceTest {

    @Autowired
    private IEmployeeService employeeService;
    
    private static String userName = "testuser";
    
    @Before
    public void init(){
	
	
	EmployeeBO employee = employeeService.findEmployeeByUserName(userName);
	if(employee != null){
	    employeeService.deleteEmployee(employee);
	}
	
	EmployeeBO employeeToSave = new EmployeeBO();
	
	
	employeeToSave.setUserName("testuser");
	employeeToSave.setEmployeeName("test");
	employeeToSave.setAge(20);
	employeeToSave.setNoOfHoldingTasks(0);
	employeeService.saveOrUpdateEmployee(employeeToSave);
    }

   /*
    
         Go To Employee Class and run the this test twice : once by commenting under-noted lines and another test run by un-commenting these line
         in Employee Class. And Try To understand how @Version saves us from Lost Update In this case.
         
        @Version
	private Long version; 
	
    * 
    */
    
    @Test
    public void testLostUpdateCase() {

	

	EmployeeBO employeeRead1 = employeeService.findEmployeeByUserName(userName);
	EmployeeBO employeeRead2 = employeeService.findEmployeeByUserName(userName);
	
	Assert.assertEquals(employeeRead1.equals(employeeRead2), true);
	
	employeeRead1.setNoOfHoldingTasks(employeeRead1.getNoOfHoldingTasks() + 1);
	
	employeeService.saveOrUpdateEmployee(employeeRead1);
	
	employeeRead2.setNoOfHoldingTasks(employeeRead2.getNoOfHoldingTasks() + 1);
	
	try {
	    employeeService.saveOrUpdateEmployee(employeeRead2);
	} catch (OptimisticLockingFailureException e) {
	    employeeRead2 = employeeService.findEmployeeByUserName(userName); 
	    employeeRead2.setNoOfHoldingTasks(employeeRead2.getNoOfHoldingTasks() + 1);
	    employeeService.saveOrUpdateEmployee(employeeRead2);
	}
	
	EmployeeBO employeeRead3 = employeeService.findEmployeeByUserName(userName);
	employeeRead3.getNoOfHoldingTasks();
	
	Assert.assertEquals((employeeRead1.equals(employeeRead3) && employeeRead2.equals(employeeRead3)), true);
	
	Assert.assertEquals(employeeRead3.getNoOfHoldingTasks(), 2);
	
	
	
    }

}
