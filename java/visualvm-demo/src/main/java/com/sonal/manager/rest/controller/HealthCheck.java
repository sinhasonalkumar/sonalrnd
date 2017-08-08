package com.sonal.manager.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.manager.rest.vo.DemoVO;
import com.sonal.manager.rest.vo.HealthVO;

import reactor.core.publisher.Mono;

@RestController
public class HealthCheck {
	
    private List<DemoVO> demos;
	
	@GetMapping(value="/healthCheck")
	public Mono<ResponseEntity<HealthVO>> healthCheck(){
		HealthVO health = new HealthVO();
		health.setStatus("Manager Healthy !! ");
		ResponseEntity<HealthVO> response = new  ResponseEntity<>(health,HttpStatus.OK);
		return Mono.just(response);
	}
	
	@GetMapping(value="/start")
	public Mono<ResponseEntity<HealthVO>> start(){
		HealthVO health = new HealthVO();
		
		demos = new ArrayList<>(); 
		
		for (int i = 0; i <=100000; i++) {
		    demos.add(new DemoVO(UUID.randomUUID().toString()));
		}
		
		health.setStatus("Manager Healthy !! ");
		ResponseEntity<HealthVO> response = new  ResponseEntity<>(health,HttpStatus.OK);
		return Mono.just(response);
	}
	

	@GetMapping(value="/end")
	public Mono<ResponseEntity<HealthVO>> end(){
		HealthVO health = new HealthVO();
		
		if(!CollectionUtils.isEmpty(demos))
		    demos = null;
		
		health.setStatus("Manager Healthy !! ");
		ResponseEntity<HealthVO> response = new  ResponseEntity<>(health,HttpStatus.OK);
		return Mono.just(response);
	}
	
	

}
