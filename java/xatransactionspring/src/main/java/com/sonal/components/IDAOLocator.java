package com.sonal.components;

import com.sonal.persistence.dao.IEmployeeDAO;

public interface IDAOLocator {

	IEmployeeDAO getEmployeeDAO();

}
