package com.sonal.executor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.components.IResourceManager;
import com.sonal.config.AppConfig;
import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.routingds.RoutingDataSourceContext;
import com.sonal.persistence.routingds.enums.OperationType;
import com.sonal.service.IEmployeeService;

public class SpringHibernateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		IResourceManager resourceManager = ctx.getBean(IResourceManager.class);
		IEmployeeService employeeService = resourceManager.getServiceLocator().getEmployeeService();
		RoutingDataSourceContext.setOperationType(OperationType.WRITE);
		employeeService.saveEmployeesInBulk(buildEmployees());
		
		RoutingDataSourceContext.setOperationType(OperationType.READ);
		List<Employee> allEmloyee = employeeService.getAllEmloyee();
		int count =0;
		for (Employee employee : allEmloyee) {
			System.out.println(employee.getEmployeeName());
			count ++;
		}
		System.out.println("Count :: " + count);
		System.out.println("Done");
	}
	
	private static List<Employee> buildEmployees(){
		List<Employee> empoEmployees = new ArrayList<Employee>();
		Employee employee = null;
		for (int i = 0; i < 100 ; i++) {
			employee = new Employee();
			employee.setEmployeeName("Employee" + i);
			empoEmployees.add(employee);
		}
		
		return empoEmployees;
	}
}
