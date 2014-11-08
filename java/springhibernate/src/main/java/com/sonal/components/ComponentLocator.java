package com.sonal.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentLocator implements IComponentLocator{

	@Autowired
	private IServiceLocator serviceLocator;
	
	@Autowired
	private IDAOLocator daoLocator;

	@Override
	public IServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	@Override
	public IDAOLocator getDaoLocator() {
		return daoLocator;
	}
	
	
}
