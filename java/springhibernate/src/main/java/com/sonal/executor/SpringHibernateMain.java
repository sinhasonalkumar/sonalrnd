package com.sonal.executor;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.AppConfig;
import com.sonal.persistence.bo.Employee;
import com.sonal.service.IEmployeeService;

public class SpringHibernateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		IEmployeeService employeeService = ctx.getBean(IEmployeeService.class);
		List<Employee> allEmloyee = employeeService.getAllEmloyee();
		for (Employee employee : allEmloyee) {
			System.out.println(employee.getEmployeeName());
		}
		System.out.println("Done");
	}
}
