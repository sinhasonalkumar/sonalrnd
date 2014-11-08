package com.sonal.testaudit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.testaudit.audit.AuditService;

@Aspect
@Component
public class AuditAspect {

	//<bean class="com.sonal.testaudit.aspect.AuditAspect" factory-method="aspectOf"/>
	//Autowire will work if add above line applicationcontext.xml.
	//Since the aspect is created before the Spring container, you have to retrieve the aspect from the Aspect's factory method aspectOf
	@Autowired
	private AuditService auditService;

	@Around("execution(* com.sonal.testaudit.services..*(..))")
	public Object auditActivity(ProceedingJoinPoint joinPoint) throws Throwable {
		beforeAudit();
		Object proceed = null;
		try {
			proceed = joinPoint.proceed();
		} catch (Throwable e) {
			exceptionAudit();
			throw new Throwable(e);
		}
		afterAudit();

		return proceed;
	}

	public void beforeAudit() throws Throwable {
		auditService.beforeAudit();
	}

	public void afterAudit() throws Throwable {
		auditService.afterAudit();
	}

	public void exceptionAudit() throws Throwable {
		auditService.exceptionAudit();
	}

}
