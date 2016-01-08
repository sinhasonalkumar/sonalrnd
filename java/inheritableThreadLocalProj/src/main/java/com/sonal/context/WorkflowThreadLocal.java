package com.sonal.context;

public class WorkflowThreadLocal extends InheritableThreadLocal<WorkflowContext> {

    @Override
    protected WorkflowContext childValue(WorkflowContext parentValue) {
	
	return super.childValue(parentValue);
    }

    
}
