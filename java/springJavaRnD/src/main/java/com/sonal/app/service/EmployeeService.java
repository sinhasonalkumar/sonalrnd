package com.sonal.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.app.dao.EmployeeDAO;
import com.sonal.app.persistence.entity.Address;
import com.sonal.app.persistence.entity.Employee;
import com.sonal.app.persistence.entity.Skill;
import com.sonal.app.service.transactiontypes.ReadOnlyTransactional;
import com.sonal.util.annotation.LogStatement;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	// @ReadOnlyTransactional
	public List<Address> printAllAddress(){
		List<Address> adresses = new ArrayList<Address>();
		List<Employee> employeeWithAddress = employeeDAO.getEmployeeWithAddress();
		for(Employee employee : employeeWithAddress){
			adresses.addAll(employee.getAddress());
		}
		for (Address address : adresses) {
			System.out.println("###################");
			@LogStatement(message ="Value of :: ")
			String streetAddress = address.getStreetAddress();
			System.out.println(streetAddress);
			System.out.println("###################");
		}
		return adresses;
	}

	// @ReadOnlyTransactional
	public List<Skill> printAllSKills() {
		List<Skill> skills = new ArrayList<Skill>();
		List<Employee> employeeWithSkills = employeeDAO.getEmployeeWithSkills();
		// List<Employee> employeeWithSkills = employeeDAO.getEmployees();
		for (Employee employee : employeeWithSkills) {
			skills.addAll(employee.getSkills());
		}
		for (Skill skill : skills) {
			System.out.println("###################");
			System.out.println(skill.getSkillName());
			System.out.println("###################");
		}
		return skills;
	}

	@ReadOnlyTransactional
	public void printAllSKillsNSubjects() {
		List<Skill> skills = new ArrayList<Skill>();
		List<Employee> employeeWithSkillsNAddress = employeeDAO.getEmployeeWithSKillsNSubjects();
		for (Employee employee : employeeWithSkillsNAddress) {
			employee.getAddress();
		}
		for (Employee employee : employeeWithSkillsNAddress) {
			employee.getSkills();
		}

	}

	@ReadOnlyTransactional
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeDAO.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmpName());
		}
		return employees;
	}
}
