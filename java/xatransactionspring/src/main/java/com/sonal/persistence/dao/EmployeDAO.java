package com.sonal.persistence.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sonal.persistence.bo.Employee;

@Repository
public class EmployeDAO implements IEmployeeDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Employee> findAllEmployees() {
	List<Employee> employees = null;
	employees = (List<Employee>) hibernateTemplate.findByNamedQuery("getAllEmplyees");
	return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
	//Session currentSession = hibernateTemplate.getSessionFactory().getCurrentSession();
	hibernateTemplate.save(employee);
	//currentSession.flush();

    }
}
