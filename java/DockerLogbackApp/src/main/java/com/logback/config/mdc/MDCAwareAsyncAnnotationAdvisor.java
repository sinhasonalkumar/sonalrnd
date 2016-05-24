package com.logback.config.mdc;

import java.util.concurrent.Executor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncAnnotationAdvisor;

public class MDCAwareAsyncAnnotationAdvisor extends AsyncAnnotationAdvisor {

	private static final long serialVersionUID = 1L;
	
	public MDCAwareAsyncAnnotationAdvisor() {
		super();
	}
	
	public MDCAwareAsyncAnnotationAdvisor(Executor executor) {
		super(executor,null);
	}
	
	@Override
	protected Advice buildAdvice(Executor executor,AsyncUncaughtExceptionHandler exceptionHandler) {
		return new MDCAwareAnnotationAsyncExecutionInterceptor(executor);
	}
}
