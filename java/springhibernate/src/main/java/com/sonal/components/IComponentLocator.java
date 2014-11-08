package com.sonal.components;

public interface IComponentLocator {

	IDAOLocator getDaoLocator();

	IServiceLocator getServiceLocator();

}
