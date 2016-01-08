package com.sonal.context;

public class WorkflowContextHolder {

    private static final InheritableThreadLocal<WorkflowContext> workflowContextInheritableThreadLocal = new InheritableThreadLocal<WorkflowContext>(); 
	
	public static void setWorkflowContext(WorkflowContext workflowContext) {
		workflowContextInheritableThreadLocal.set(workflowContext);
	}
	
	public static WorkflowContext getWorkflowContext() {
		WorkflowContext workflowContext = workflowContextInheritableThreadLocal.get();
		return workflowContext;
	}
	
	public static void removeWorkflowContext() {
		workflowContextInheritableThreadLocal.remove();
	}
}
