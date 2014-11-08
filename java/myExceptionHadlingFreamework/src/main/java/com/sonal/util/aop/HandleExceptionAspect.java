package com.sonal.util.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.sonal.util.annotation.HandleException;
import com.sonal.util.exception.AppException;

@Component
@Aspect
public class HandleExceptionAspect {

	@Around("@annotation(com.sonal.util.annotation.HandleException)")
	public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		String errorMessage = null;
		String errorCode = null;
		Class exceptionClass = null;
		String exceptionType = null;
		try {
			Class requestedClass = joinPoint.getSignature().getDeclaringType();
			String requestedMethodName = joinPoint.getSignature().getName();
			HandleException handleException = null;
			for (Method method : requestedClass.getMethods()) {
				if(method.getName().equalsIgnoreCase(requestedMethodName)){
					handleException = method.getAnnotation(HandleException.class);
					break;
				}
			}
			
			if (handleException != null) {
				errorMessage = handleException.errorMessage();
				errorCode = handleException.errorCode();
				exceptionClass = handleException.clazz();
				exceptionType = handleException.exceptionType();
			}else{
				errorMessage = "FATAL_ERROR";
				errorCode = "FAT_01";
				exceptionClass = requestedClass;
				exceptionType = requestedClass.getName();
			}
			result = joinPoint.proceed();
		} catch (Throwable e) {
			AppException appException = null;
			String rootCause = null;
			if (e instanceof AppException) {
				appException = (AppException) e;
				if(appException != null){
					rootCause = appException.getRootCause();
					
				}
			}
			if(rootCause == null){
				rootCause = e.toString();
			}
			
			throw new AppException(errorMessage, errorCode, exceptionType, exceptionClass, rootCause,e);
		}
		return result;
	}

}
