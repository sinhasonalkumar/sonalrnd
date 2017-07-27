package com.sonal.manager.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.manager.rest.vo.JobRequestVO;
import com.sonal.manager.rest.vo.JobResponseVO;
import com.sonal.manager.service.JobProcessor;

import reactor.core.publisher.Mono;

@RestController
public class JobRegistrator {
	
	
	@Autowired
	private JobProcessor jobProcessor;

	@PostMapping(value="/checkJobStatus",consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<JobResponseVO>> checkJobStatus(@RequestBody JobRequestVO jobRequestVO){
		
		return jobProcessor.checkJobStatus(jobRequestVO)
					       .map(jr -> new ResponseEntity<>(jr, HttpStatus.OK));
		
	}
}
