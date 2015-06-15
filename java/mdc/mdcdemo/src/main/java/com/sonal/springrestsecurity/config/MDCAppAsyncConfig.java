package com.sonal.springrestsecurity.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@Configuration
public class MDCAppAsyncConfig extends AsyncConfigurerSupport {

    private Logger logger = LoggerFactory.getLogger(MDCAppAsyncConfig.class);
    @Override
    public Executor getAsyncExecutor() {
	ExecutorService fixedThreadPoolSexecutor = Executors.newCachedThreadPool();
	return fixedThreadPoolSexecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler = new AsyncUncaughtExceptionHandler() {
	    
	    @Override
	    public void handleUncaughtException(Throwable arg0, Method method, Object... args) {
		logger.error("Uncaught Exception in Async Process :: " + " :: Class :: " + method.getClass().getName() + " :: Method :: " + method.getName());
		logger.error("Args :: ");
		for (Object arg : args) {
		    logger.error(arg.toString());
		}
	    }
	};
	return asyncUncaughtExceptionHandler;
    }
    
     

}
