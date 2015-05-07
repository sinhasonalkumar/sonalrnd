package com.sonal.batch.schedular;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.batch.config.BatchAppConfig;

public class DynamicBatchJobMain {

    public static void main(String[] args) {
   	ApplicationContext context = new AnnotationConfigApplicationContext(BatchAppConfig.class);
   	JobRunner taskletOrientedJobRunner = context.getBean(JobRunner.class);
   	taskletOrientedJobRunner.starttaskletOrientedJob();
   	
       }
}
