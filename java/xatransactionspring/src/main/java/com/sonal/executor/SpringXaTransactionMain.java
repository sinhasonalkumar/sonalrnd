package com.sonal.executor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.components.IResourceManager;
import com.sonal.config.AppConfig;
import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.bo.EmployeeExpense;
import com.sonal.service.IEmployeeService;

public class SpringXaTransactionMain {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.register(AppConfig.class);
	ctx.refresh();
	IResourceManager resourceManager = ctx.getBean(IResourceManager.class);
	IEmployeeService employeeService = resourceManager.getServiceLocator().getEmployeeService();

	employeeService.saveEmployeesInBulk(buildEmployees());
	List<Employee> allEmloyee = employeeService.getAllEmloyee();
	int count = 0;
	for (Employee employee : allEmloyee) {
	    System.out.println(employee.getEmployeeName());
	    count++;
	}
	System.out.println("Count :: " + count);
	System.out.println("Done");
    }

    private static Map<Employee, EmployeeExpense> buildEmployees() {
	Map<Employee, EmployeeExpense> empoEmployees = new HashMap<Employee, EmployeeExpense>();
	Employee employee = null;
	EmployeeExpense employeeExpense = null;
	for (int i = 0; i < 10; i++) {
	    employee = new Employee();
	    employee.setEmployeeName("Employee" + i);
	    
	    employeeExpense = new EmployeeExpense();
	    //employeeExpense.setEmpId(employee.getId());
	    employeeExpense.setExpense(new BigDecimal(1200));
	    
	    empoEmployees.put(employee,employeeExpense);
	}

	return empoEmployees;
    }
}
