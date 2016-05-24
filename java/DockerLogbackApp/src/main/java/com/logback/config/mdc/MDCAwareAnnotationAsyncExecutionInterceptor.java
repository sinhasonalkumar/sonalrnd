package com.logback.config.mdc;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AnnotationAsyncExecutionInterceptor;
import org.springframework.util.ClassUtils;

public class MDCAwareAnnotationAsyncExecutionInterceptor extends AnnotationAsyncExecutionInterceptor {

    private final Logger logger = LoggerFactory.getLogger(MDCAwareAnnotationAsyncExecutionInterceptor.class);
    
    public MDCAwareAnnotationAsyncExecutionInterceptor(Executor defaultExecutor) {
	super(defaultExecutor);
    }

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {

	Class<?> targetClass = (invocation.getThis() != null ? AopUtils.getTargetClass(invocation.getThis()) : null);
	Method specificMethod = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);
	final Method userDeclaredMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

	AsyncTaskExecutor executor = determineAsyncExecutor(userDeclaredMethod);
	if (executor == null) {
	    throw new IllegalStateException("No executor specified and no default executor set on AsyncExecutionInterceptor either");
	}
	
	logger.info("Testing Aync Interception ");

	Callable<Object> task = buildCallable(userDeclaredMethod, invocation);

	return doSubmit(task, executor, invocation.getMethod().getReturnType());

    }

    protected Callable<Object> buildCallable(final Method userDeclaredMethod,final MethodInvocation invocation) {
	Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
	return new MDCAwareCallable(userDeclaredMethod,invocation, copyOfContextMap);
    }

    private class MDCAwareCallable implements Callable<Object> {

	private final MethodInvocation invocation;

	private final Map<String, String> mdcContextMap;
	
	final Method userDeclaredMethod;

	public MDCAwareCallable(final Method userDeclaredMethod,final MethodInvocation invocation, Map<String, String> mdcContextMap) {
	    this.invocation = invocation;
	    this.mdcContextMap = mdcContextMap;
	    this.userDeclaredMethod = userDeclaredMethod;

	}

	@Override
	public Object call() throws Exception {

	    try {
		//MDC.setContextMap(mdcContextMap);
		Object result = invocation.proceed();
		if (result instanceof Future) {
		    return ((Future<?>) result).get();
		}
	    } catch (ExecutionException ex) {
		handleError(ex.getCause(), userDeclaredMethod, invocation.getArguments());
	    } catch (Throwable ex) {
		handleError(ex, userDeclaredMethod, invocation.getArguments());
	    }
	    return null;

	}
    }

}
