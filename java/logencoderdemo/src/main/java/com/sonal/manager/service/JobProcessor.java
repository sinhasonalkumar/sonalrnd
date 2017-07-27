package com.sonal.manager.service;

import static net.logstash.logback.marker.Markers.append;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sonal.manager.rest.vo.JobRequestVO;
import com.sonal.manager.rest.vo.JobResponseVO;

import reactor.core.publisher.Mono;

@Service
public class JobProcessor {
    
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Mono<JobResponseVO> checkJobStatus(JobRequestVO jobRequestVO){
		
		JobResponseVO jobResponseVO = new JobResponseVO(jobRequestVO.getJobRequestId(),"COMPLETED");
		//jobResponseVO = null;
		logger.info(append("jobResponseVO", jobResponseVO), jobResponseVO.toString());
		//logger.info("log message {}", value("name", "value"));
		
		try{
		    
		    throw new Exception("Some Exception Thrown To Test !!");
		    
		}catch (Exception e) {
		   logger.error("Exception : ",e);
		}
		
		
		return Mono.just(jobResponseVO);
	}
}
