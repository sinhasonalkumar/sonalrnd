package com.sonal.util.aop;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sonal.util.logtransactiopncontext.LogTransactionContext;

@Component
@Aspect
public class LoggingAspect {

	@Around("execution(* com.sonal.app..*(..))")
	@Order(value = 2)
	public Object startLogging(ProceedingJoinPoint joinPoint) {
		Object returnedObject = null;
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringType().getName();
		String methodName = signature.getName();
		Object[] methodArgs = joinPoint.getArgs();

		try {
			System.out.println("Start  :: " + LogTransactionContext.getTransactionId() + " :: Entering Method  " + signature + " with arguments as " + methodArgs);
			returnedObject = joinPoint.proceed();
			System.out.println(signature + " Method  --> Returned :: " + returnedObject);
			System.out.println("End :: " + LogTransactionContext.getTransactionId() + " :: Coming Out From Method " + signature);
		} catch (Throwable e) {
			System.err.println("Exception Found in :: " + LogTransactionContext.getTransactionId() + " :: " + signature);
			System.err.println(e.toString());
			e.printStackTrace();
		}
		return returnedObject;
	}

	@Before("execution(* com.sonal.app.main.MainClass.main(..))")
	@Order(value = 1)
	public void generateLogTransactionId(JoinPoint joinPoint) {

		try {
			UUID transactionID = UUID.randomUUID();
			LogTransactionContext.setTransactionId(transactionID);

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

}
