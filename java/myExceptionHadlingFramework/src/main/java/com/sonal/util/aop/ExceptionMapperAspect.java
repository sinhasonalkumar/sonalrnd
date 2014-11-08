package com.sonal.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.sonal.util.exception.AppException;

@Component
@Aspect
public class ExceptionMapperAspect {

	@Around("@annotation(com.sonal.util.annotation.MapException)")
	public Object mapException(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {

			if (e instanceof AppException) {
				AppException appException = (AppException) e;
				System.out.println(appException.getErrorCode());
				System.out.println(appException.getErrorMessage());
				System.out.println(appException.getExceptionType());
				System.out.println(appException.getExceptionClass());
				System.out.println(appException.getRootCause());
				// appException.printStackTrace();
			}
		}

		return result;

	}
}
