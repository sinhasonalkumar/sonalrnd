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

import com.sonal.batch.DAO.IStepConfigDao;
import com.sonal.batch.config.batchappcontext.JobRequestContext;
import com.sonal.batch.config.batchappcontext.JobRequestVO;

@Service
public class JobRunner {

    @Autowired
    private Job taskletOrientedJob;
    
    @Autowired
    private Job taskletOrientedParallelStepsJob;

    @Autowired
    private SimpleJobLauncher jobLauncher;
    
    @Autowired
    private IStepConfigDao stepConfigDao;

    public JobExecution startTaskletOrientedJob(JobRequestVO jobRequestVO) {
	Map<String, String> stepToTaskletMapping = stepConfigDao.getStepToTaskletMapping(jobRequestVO.getJobRequestId());
	jobRequestVO.setStepToTaskLetMap(stepToTaskletMapping);
	JobExecution jobExecution = null;
	Map<String, JobParameter> params = new HashMap<String, JobParameter>();
	    params.put("jobStartTime", new JobParameter(System.currentTimeMillis()));
	    params.put("jobRequestId", new JobParameter(jobRequestVO.getJobRequestId()));
	    JobParameters jobParameters = new JobParameters(params);
	JobRequestContext.setJobRequestVO(jobRequestVO);    
	try {
	    jobExecution = jobLauncher.run(taskletOrientedJob, jobParameters);
	} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
	    e.printStackTrace();
	}
	return jobExecution;
    }
    
    
    
    public JobExecution starttaskletOrientedParallelStepsJob(JobRequestVO jobRequestVO) {
	Map<String, String> stepToTaskletMapping = stepConfigDao.getStepToTaskletMapping(jobRequestVO.getJobRequestId());
	jobRequestVO.setStepToTaskLetMap(stepToTaskletMapping);
	JobExecution jobExecution = null;
	Map<String, JobParameter> params = new HashMap<String, JobParameter>();
	    params.put("jobStartTime", new JobParameter(System.currentTimeMillis()));
	    params.put("jobRequestId", new JobParameter(jobRequestVO.getJobRequestId()));
	    JobParameters jobParameters = new JobParameters(params);
	JobRequestContext.setJobRequestVO(jobRequestVO);    
	try {
	    jobExecution = jobLauncher.run(taskletOrientedParallelStepsJob, jobParameters);
	} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
	    e.printStackTrace();
	}
	return jobExecution;
    }
    
    
    
}
