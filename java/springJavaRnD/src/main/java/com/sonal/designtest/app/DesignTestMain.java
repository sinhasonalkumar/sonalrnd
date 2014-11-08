package com.sonal.designtest.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sonal.designtest.ComponentLocator;
import com.sonal.designtest.ComponentLocatorProxy;

public class DesignTestMain {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComponentLocator componentLocator = ComponentLocatorProxy.getComponentLocatorInstance();
		componentLocator.getFactoryLocator().getFactory().getSomeInstance();
		componentLocator.getServiceLocator().getService().doSomething();
	}
}
