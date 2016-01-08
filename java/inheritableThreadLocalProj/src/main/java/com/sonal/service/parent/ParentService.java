package com.sonal.service.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.sonal.context.WorkflowContext;
import com.sonal.context.WorkflowContextHolder;
import com.sonal.service.child.ChildService1;
import com.sonal.service.child.ChildService2;
import com.sonal.vo.ChildResultVO;
import com.sonal.vo.FeatureResuultVO;

@Service
public class ParentService {

    @Autowired
    private ChildService1 childService1;
    
    @Autowired
    private ChildService2 childService2;
    
    @Async
    public ListenableFuture<FeatureResuultVO> triggerComplexFeature(){
	
	WorkflowContext workflowContext = WorkflowContextHolder.getWorkflowContext();
	System.out.println("Thread Id :: " + Thread.currentThread().getId() +  " :: ParentService :: " + workflowContext);
	
	FeatureResuultVO featureResuultVO = new FeatureResuultVO();
	
	final ChildResultVO childResultVO = new ChildResultVO();
	
	ListenableFuture<Boolean> childService1Response = childService1.doSomeThing();
	childService1Response.addCallback(new ListenableFutureCallback<Boolean>() {

	    @Override
	    public void onFailure(Throwable t) {

		childResultVO.setChildService1Error(t);
		childResultVO.setChildService1Success(false);
		childResultVO.setChildService1Done(true);
	    }

	    @Override
	    public void onSuccess(Boolean result) {
		childResultVO.setChildService1Error(null);
		childResultVO.setChildService1Success(true);
		childResultVO.setChildService1Done(true);
		System.out.println("Thread Id :: " + Thread.currentThread().getId() +  " :: ParentService<-->childService1 :: OnSuccess" + workflowContext);
		
	    }
	      
	});
	
	
	ListenableFuture<Boolean> childService2Response = childService2.doSomeThing();
	childService2Response.addCallback(new ListenableFutureCallback<Boolean>() {

	    @Override
	    public void onFailure(Throwable t) {

		childResultVO.setChildService2Error(t);
		childResultVO.setChildService2Success(false);
		childResultVO.setChildService2Done(true);
	    }

	    @Override
	    public void onSuccess(Boolean result) {
		childResultVO.setChildService2Error(null);
		childResultVO.setChildService2Success(true);
		childResultVO.setChildService2Done(true);
		System.out.println("Thread Id :: " + Thread.currentThread().getId() +  " :: ParentService<-->childService2 :: OnSuccess" + workflowContext);
	    }
	      
	});
	
	while (!(childResultVO.isChildService1Done() && childResultVO.isChildService2Done())) {
	    //System.out.println("??????????????? Waiting For ChildService1 and ChildService2 To Finish... ?????????????????????");
	}
	
	if(!childResultVO.isChildService1Success()){
	    throw new RuntimeException(childResultVO.getChildService1Error());
	}
	if(!childResultVO.isChildService2Success()){
	    throw new RuntimeException(childResultVO.getChildService2Error());
	}
	
	featureResuultVO.setFeatureName(Thread.currentThread().getId() +  " :: Just Testing Inheritable Thread Lcoal Behaviour In Case Of Cached Thread Pool");
	
	return new AsyncResult<FeatureResuultVO>(featureResuultVO);
    }
}
