package com.sonal.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.persistence.dao.IEmployeeDAO;

@Component
public class DAOLocator implements IDAOLocator{

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public IEmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	
	
}
