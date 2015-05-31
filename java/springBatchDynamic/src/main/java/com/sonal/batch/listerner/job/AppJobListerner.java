package com.sonal.batch.listerner.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.util.CollectionUtils;

import com.sonal.batch.config.batchappcontext.JobRequestContext;

public class AppJobListerner implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
	if(!(JobRequestContext.getJobRequestVO() != null &&  !CollectionUtils.isEmpty(JobRequestContext.getJobRequestVO().getStepToTaskLetMap()))){
	    throw new RuntimeException("JobRequestContext Not Set Properly !!");
	}
	
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
	JobRequestContext.removeJobRequestVO();
	
    }

    
}
