package com.sonal.designtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentLocator {

	@Autowired
	private IServiceLocator serviceLocator;

	@Autowired
	private IFactoryLocator factoryLocator;

	public IServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public IFactoryLocator getFactoryLocator() {
		return factoryLocator;
	}

}
