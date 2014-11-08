package com.sonal.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainTest {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestPostConstruct testPostConstruct = appContext.getBean(TestPostConstruct.class);
		System.out.println(testPostConstruct.getField2());
		
	}
}
