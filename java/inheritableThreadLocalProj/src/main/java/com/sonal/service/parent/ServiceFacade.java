package com.sonal.service.parent;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.sonal.context.WorkflowContext;
import com.sonal.context.WorkflowContextHolder;
import com.sonal.vo.FeatureResuultVO;

@Service
public class ServiceFacade {

    @Autowired
    private ParentService parentService;

    public void doComplexFeature() {

	setWorkflowContext();

	WorkflowContext workflowContext = WorkflowContextHolder.getWorkflowContext();
	System.out.println("Thread Id :: " + Thread.currentThread().getId() +  " ::  ServiceFacade :: " + workflowContext);

	ListenableFuture<FeatureResuultVO> triggerComplexFeature = parentService.triggerComplexFeature();

	triggerComplexFeature.addCallback(new ListenableFutureCallback<FeatureResuultVO>() {

	    @Override
	    public void onFailure(Throwable t) {
		t.printStackTrace();
	    }

	    @Override
	    public void onSuccess(FeatureResuultVO featureResuultVO) {
		System.out.println(featureResuultVO.getFeatureName());
	    }

	});

	while (!triggerComplexFeature.isDone()) {
	    // System.out.println("!!!!!!!!!!!!!! Waiting For ServiceFacade To End...   !!!!!!!!!!!!!!");
	}

	clearWorkflowContextForThread();

    }

    private void clearWorkflowContextForThread() {
	WorkflowContextHolder.removeWorkflowContext();
    }

    private void setWorkflowContext() {
	WorkflowContext workflowContext = new WorkflowContext();
	workflowContext.setRequestId(UUID.randomUUID().toString());
	workflowContext.setUserId("Sonal-" + Math.random());
	WorkflowContextHolder.setWorkflowContext(workflowContext);
    }
}
