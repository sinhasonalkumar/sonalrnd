package com.sonal.executor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.components.IResourceManager;
import com.sonal.config.AppConfig;
import com.sonal.persistence.bo.Employee;
import com.sonal.service.IEmployeeService;

public class EhCacheSpringHibernateMain {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	testingReadWriteCache(ctx);
    }

    private static void testingReadWriteCache(AnnotationConfigApplicationContext ctx) {
	IResourceManager resourceManager = ctx.getBean(IResourceManager.class);
	IEmployeeService employeeService = resourceManager.getServiceLocator().getEmployeeService();
	//employeeService.saveEmployeesInBulk(buildEmployees());
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("Creating New Employeess");
	employeeService.saveEmployees(buildEmployees());
	System.out.println("-------------------------------------------------------------------------");
	
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("Trigger Database Pull");
	System.out.println("-------------------------------------------------------------------------");
	
	List<Employee> allEmloyee = employeeService.getAllEmloyee();
	
	for (Employee employee : allEmloyee) {
	    System.out.println(employee.getEmployeeName());
	   
	}
	
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("Trigger Database Pull");
	System.out.println("-------------------------------------------------------------------------");
	
	allEmloyee = employeeService.getAllEmloyee();
	
	for (Employee employee : allEmloyee) {
	    System.out.println(employee.getEmployeeName());
	   
	}
	
	
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("Creating New Employeess");
	employeeService.saveEmployees(buildEmployees());
	System.out.println("-------------------------------------------------------------------------");
	
	
	
	
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("Trigger Database Pull");
	System.out.println("-------------------------------------------------------------------------");
	allEmloyee = employeeService.getAllEmloyee();
	for (Employee employee : allEmloyee) {
	    System.out.println(employee.getEmployeeName());
	   
	}
	
	
	
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("Trigger Database Pull");
	System.out.println("-------------------------------------------------------------------------");
	allEmloyee = employeeService.getAllEmloyee();
	for (Employee employee : allEmloyee) {
	    System.out.println(employee.getEmployeeName());
	   
	}
	
	
	System.out.println("Done");
    }

    private static List<Employee> buildEmployees() {
	List<Employee> empoEmployees = new ArrayList<Employee>();
	Employee employee = null;
	for (int i = 0; i < 10; i++) {
	    employee = new Employee();
	    employee.setEmployeeName("Employee" + i);
	    empoEmployees.add(employee);
	}

	return empoEmployees;
    }
}
