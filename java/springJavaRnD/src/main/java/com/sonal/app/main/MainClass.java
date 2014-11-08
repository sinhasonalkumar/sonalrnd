package com.sonal.app.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sonal.app.persistence.entity.Address;
import com.sonal.app.persistence.entity.Employee;
import com.sonal.app.persistence.entity.Skill;
import com.sonal.app.service.TestService;

@Component
public class MainClass {

	public static void main(String[] args) throws Exception{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MainClass mainClass = appContext.getBean(MainClass.class);
		mainClass.createEmployee(appContext);
		//mainClass.showAllEmlpoyees(appContext);
	}
	
	public Employee createEmployee(ApplicationContext appContext){
		TestService testService = appContext.getBean(TestService.class);
		Employee employee1 = new Employee();
		employee1.setEmpName("Employee"+ Math.random());
		
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(employee1);
		
		
		Skill skill1 = new Skill();
		skill1.setSkillName("Java");
		skill1.setEmployees(employees);
		
		Skill skill2 = new Skill();
		skill2.setSkillName("Spring");
		skill2.setEmployees(employees);
		
		Skill skill3 = new Skill();
		skill3.setSkillName("Hibernate");
		skill3.setEmployees(employees);
		
		Set<Skill> skills = new HashSet<Skill>();
		skills.add(skill1);
		skills.add(skill2);
		skills.add(skill3);
		
		employee1.setSkills(skills);
		
		
		
		Address address1 = new Address();
		address1.setStreetAddress("test Address");
		address1.setEmployee(employee1);
		
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(address1);
		
		employee1.setAddress(addresses);
		
		
		testService.createEmployee(employee1);
		
		System.out.println(employee1.getEmpId());
		return employee1;
	}
	
	public void showAllEmlpoyees(ApplicationContext appContext) throws Exception{ 
		TestService testService = appContext.getBean(TestService.class);
		List<Employee> allEMployees = testService.getAllEMployees();
		for (Employee employee : allEMployees) {
			print(employee.getEmpId());
		}
	}
	
	private void print(Object Object){
		System.out.println(Object);
	}
}
