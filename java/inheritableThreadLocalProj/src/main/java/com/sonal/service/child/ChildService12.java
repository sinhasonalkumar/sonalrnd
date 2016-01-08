package com.sonal.service.child;

import org.springframework.stereotype.Service;

import com.sonal.context.WorkflowContext;
import com.sonal.context.WorkflowContextHolder;

@Service
public class ChildService12 {


    public void doSomeThing() {

	WorkflowContext workflowContext = WorkflowContextHolder.getWorkflowContext();
	System.out.println( "Thread Id :: " + Thread.currentThread().getId() +  " ::  ChildService12 :: " + workflowContext);
    }
}
