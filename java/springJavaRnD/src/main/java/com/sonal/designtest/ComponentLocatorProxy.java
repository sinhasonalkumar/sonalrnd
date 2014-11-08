package com.sonal.designtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentLocatorProxy {

	private static ComponentLocator componentLocator;

	@Autowired
	protected void setComponentLocator(ComponentLocator componentLocator) {
		ComponentLocatorProxy.componentLocator = componentLocator;
	}
	
	public static ComponentLocator getComponentLocatorInstance(){
		return componentLocator;
	}

}
