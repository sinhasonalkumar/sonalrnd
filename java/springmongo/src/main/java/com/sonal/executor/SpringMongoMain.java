package com.sonal.executor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.AppConfig;
import com.sonal.persistence.bo.Employee;
import com.sonal.service.IEmployeeService;


public class SpringMongoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IEmployeeService employeeService = applicationContext.getBean(IEmployeeService.class);
		
		Employee employeeToSave = new Employee();
		
		employeeToSave.setEmployeeName("test");
		employeeToSave.setAge(20);
		
		List<Employee> employees = new ArrayList<Employee>();
		//employees.add(employeeToSave);
		
		employeeService.saveEmployeesInBulk(employees);
		
		
		List<Employee> allEmloyee = employeeService.getAllEmloyee();
		for (Employee employee : allEmloyee) {
			System.out.println(employee.getId());
			System.out.println(employee.getEmployeeName());
			System.out.println(employee.getAge());
			
		}
	}
	
}
