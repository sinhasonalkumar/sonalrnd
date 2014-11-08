package com.sonal.app.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sonal.app.persistence.entity.Employee;
import com.sonal.app.service.TestService;

@Component
public class MainClass {

	public static void main(String[] args) throws Exception{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MainClass mainClass = appContext.getBean(MainClass.class);
		//mainClass.createEmployee(appContext);
		mainClass.showAllEmlpoyees(appContext);
	}
	
	public Employee createEmployee(ApplicationContext appContext){
		TestService testService = appContext.getBean(TestService.class);
		Employee employee = new Employee();
		employee.setEmpName("Employee" + System.currentTimeMillis());
		testService.createEmployee(employee);
		System.out.println(employee.getId());
		return employee;
	}
	
	public void showAllEmlpoyees(ApplicationContext appContext) throws Exception{ 
		TestService testService = appContext.getBean(TestService.class);
		List<Employee> allEMployees = testService.getAllEMployees();
		for (Employee employee : allEMployees) {
			print(employee.getId());
		}
	}
	
	private void print(Object Object){
		System.out.println(Object);
	}
}
