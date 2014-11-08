package com.sonal.testaudit.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuditAppTest {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AuditApp auditApp = (AuditApp) appContext.getBean(AuditApp.class);
		auditApp.complexActivity();

	}

}
