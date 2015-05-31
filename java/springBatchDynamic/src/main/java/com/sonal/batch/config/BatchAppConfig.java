package com.sonal.batch.config;

import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sonal.batch.config.batchappcontext.JobRequestContext;
import com.sonal.batch.listerner.job.AppJobListerner;
import com.sonal.batch.tasklets.JobWrapupTasklet;
import com.sonal.batch.tasklets.TaskletA;
import com.sonal.batch.tasklets.TaskletB;
import com.sonal.batch.tasklets.TaskletC;
import com.sonal.batch.tasklets.TaskletD;

@Configuration
@ComponentScan(basePackages = { "com.sonal" })
@EnableBatchProcessing
public class BatchAppConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public SimpleJobLauncher jobLauncher() {
	SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
	simpleJobLauncher.setJobRepository(jobRepository());
	return simpleJobLauncher;
    }

    @Bean
    public ResourcelessTransactionManager transactionManager() {
	ResourcelessTransactionManager resourcelessTransactionManager = new ResourcelessTransactionManager();
	return resourcelessTransactionManager;
    }

    @Bean
    public JobRepository jobRepository() {
	MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean();
	mapJobRepositoryFactoryBean.setTransactionManager(transactionManager());
	JobRepository jobRepository = null;
	try {
	    jobRepository = mapJobRepositoryFactoryBean.getObject();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return jobRepository;
    }

    @Bean
    public Job taskletOrientedJob() {

	Job job = jobBuilderFactory.get("Job :: Tasklet_Oriented_Job").listener(appJobListerner())
				   .start(Step1()).next(Step2()).next(Step3()).next(Step4()).next(JobWrapupStep()).build();
	return job;
    }

    @Bean
    public AppJobListerner appJobListerner() {
	return new AppJobListerner();
    }

    @JobScope
    @Bean
    public Step Step1() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: Step1");

	TaskletStep taskletofStep1 = stepBuilder.tasklet(getConfiguredTaskletByStep("step1")).build();

	return taskletofStep1;
    }

    @JobScope
    @Bean
    public Step Step2() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: Step2");

	TaskletStep taskletofStep2 = stepBuilder.tasklet(getConfiguredTaskletByStep("step2")).build();

	return taskletofStep2;
    }

    @JobScope
    @Bean
    public Step Step3() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: Step3");

	TaskletStep taskletofStep3 = stepBuilder.tasklet(getConfiguredTaskletByStep("step3")).build();

	return taskletofStep3;
    }

    @JobScope
    @Bean
    public Step Step4() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: Step4");

	TaskletStep taskletofStep4 = stepBuilder.tasklet(getConfiguredTaskletByStep("step4")).build();

	return taskletofStep4;
    }

    @JobScope
    @Bean
    public Step JobWrapupStep() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: JobWrapupStep");

	TaskletStep jobWrapupStep = stepBuilder.tasklet(getConfiguredTaskletByStep("jobWrapupStep")).build();

	return jobWrapupStep;
    }

    public Tasklet getConfiguredTaskletByStep(String stepName) {
	Tasklet tasklet = null;
	Map<String, String> stepToTaskletMap = JobRequestContext.getJobRequestVO().getStepToTaskLetMap();
	String taskletName = stepToTaskletMap.get(stepName);

	switch (taskletName) {
	case "taskletA": {
	    tasklet = taskletA();
	    break;
	}

	case "taskletB": {
	    tasklet = taskletB();
	    break;
	}

	case "taskletC": {
	    tasklet = taskletC();
	    break;
	}

	case "taskletD": {
	    tasklet = taskletD();
	    break;
	}

	case "jobWrapupTasklet": {
	    tasklet = jobWrapupTasklet();
	    break;
	}
	default:
	    tasklet = null;
	    break;
	}

	return tasklet;
    }

    @Bean
    public TaskletA taskletA() {
	return new TaskletA();
    }

    @Bean
    public TaskletB taskletB() {
	return new TaskletB();
    }

    @Bean
    public TaskletC taskletC() {
	return new TaskletC();
    }

    @Bean
    public TaskletD taskletD() {
	return new TaskletD();
    }

    @Bean
    public JobWrapupTasklet jobWrapupTasklet() {
	return new JobWrapupTasklet();
    }

}
