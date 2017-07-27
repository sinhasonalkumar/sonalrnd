package com.sonal.manager.service;

import org.springframework.stereotype.Service;

import com.sonal.manager.rest.vo.JobRequestVO;
import com.sonal.manager.rest.vo.JobResponseVO;

import reactor.core.publisher.Mono;

@Service
public class JobProcessor {
	
	public Mono<JobResponseVO> checkJobStatus(JobRequestVO jobRequestVO){
		
		JobResponseVO JobResponseVO = new JobResponseVO(jobRequestVO.getJobRequestId(),"COMPLETED");
		
		return Mono.just(JobResponseVO);
	}
}
