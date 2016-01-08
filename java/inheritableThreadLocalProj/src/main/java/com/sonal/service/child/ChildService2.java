package com.sonal.service.child;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.sonal.context.WorkflowContext;
import com.sonal.context.WorkflowContextHolder;

@Service
public class ChildService2 {

    @Async
    public ListenableFuture<Boolean> doSomeThing() {
	
	WorkflowContext workflowContext = WorkflowContextHolder.getWorkflowContext();
	System.out.println( "Thread Id :: " + Thread.currentThread().getId() +  " ::  ChildService2 :: " + workflowContext);

	return new AsyncResult<Boolean>(true);
    }
}
