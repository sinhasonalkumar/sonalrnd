package com.sonal.batch.schedular;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRunner {

    @Autowired
    private Job taskletOrientedJob;

    @Autowired
    private SimpleJobLauncher jobLauncher;

    public JobExecution starttaskletOrientedJob() {
	JobExecution jobExecution = null;
	Map<String, JobParameter> params = new HashMap<String, JobParameter>();
	    params.put("time", new JobParameter(System.currentTimeMillis()));
	    JobParameters jobParameters = new JobParameters(params);
	try {
	    jobExecution = jobLauncher.run(taskletOrientedJob, jobParameters);
	} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
	    e.printStackTrace();
	}
	return jobExecution;
    }
}
