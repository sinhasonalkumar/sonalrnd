package com.sonal.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sonal.app.persistence.entity.Employee;

@Repository
public class TestDAO extends BaseDAO {

	
	public List<Employee> getAllEMployees() {
		//List<Employee> employees = (List<Employee>) sessionFactory.getCurrentSession().createQuery("from Employee").list();
		List<Employee> employees = (List<Employee>) getHibernateTemplate().find("from Employee");
		//System.out.println(0/0);
		return employees;
	}

	
	public Employee createEmployee(Employee emp) {
		//sessionFactory.getCurrentSession().save(emp);
	     getHibernateTemplate().save(emp);
		return emp;
	}
	
}
