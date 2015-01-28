package com.sonal.collection.sort.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ComparableMain {

	public static void main(String[] args) {
		EmployeeVO employeeVO1 = new EmployeeVO();
		employeeVO1.setAge(29);
		employeeVO1.setEmpName("ABC");
		
		
		EmployeeVO employeeVO2 = new EmployeeVO();
		employeeVO2.setAge(30);
		employeeVO2.setEmpName("UVW");
		
		
		
		EmployeeVO employeeVO3 = new EmployeeVO();
		employeeVO3.setAge(28);
		employeeVO3.setEmpName("XYZ");
		
		EmployeeVO employeeVO4 = new EmployeeVO();
		employeeVO4.setAge(30);
		employeeVO4.setEmpName("EFG");
		
		List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
		employees.add(employeeVO1);
		employees.add(employeeVO2);
		employees.add(employeeVO3);
		employees.add(employeeVO4);
		
		System.out.println("Before Sorting");
		
		System.out.println(employees);
		
		Collections.sort(employees);
		
		System.out.println("After Sorting");
		
		System.out.println(employees);
		
	}
}
