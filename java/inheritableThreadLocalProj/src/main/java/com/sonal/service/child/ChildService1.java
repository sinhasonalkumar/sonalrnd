package com.sonal.service.child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.sonal.context.WorkflowContext;
import com.sonal.context.WorkflowContextHolder;

@Service
public class ChildService1 {

    @Autowired
    private ChildService11 childService11;

    @Autowired
    private ChildService12 childService12;

    @Async
    public ListenableFuture<Boolean> doSomeThing() {
	
	WorkflowContext workflowContext = WorkflowContextHolder.getWorkflowContext();
	System.out.println("Thread Id :: " + Thread.currentThread().getId() +  " ::  ChildService1 :: " + workflowContext);
	
	childService11.doSomeThing();
	
	childService12.doSomeThing();
	
	
	return new AsyncResult<Boolean>(true);
    }
}
