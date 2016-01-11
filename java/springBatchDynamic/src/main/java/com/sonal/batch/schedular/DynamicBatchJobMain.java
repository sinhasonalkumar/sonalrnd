package com.sonal.batch.schedular;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.batch.config.BatchAppConfig;
import com.sonal.batch.config.batchappcontext.JobRequestVO;

public class DynamicBatchJobMain {

    public static void main(String[] args) {
   	ApplicationContext context = new AnnotationConfigApplicationContext(BatchAppConfig.class);
   	JobRunner taskletOrientedJobRunner = context.getBean(JobRunner.class);
   	String jobRequestID = UUID.randomUUID().toString();
   	JobRequestVO jobRequestVO = new JobRequestVO();
   	jobRequestVO.setJobRequestId(jobRequestID);
   	taskletOrientedJobRunner.startTaskletOrientedJob(jobRequestVO);
   	//taskletOrientedJobRunner.starttaskletOrientedParallelStepsJob(jobRequestVO);
   	
       }
}
