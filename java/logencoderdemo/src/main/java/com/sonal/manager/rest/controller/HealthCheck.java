package com.sonal.manager.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.manager.rest.vo.HealthVO;

import reactor.core.publisher.Mono;

@RestController
public class HealthCheck {
	
	
	@GetMapping(value="/healthCheck")
	public Mono<ResponseEntity<HealthVO>> healthCheck(){
		HealthVO health = new HealthVO();
		health.setStatus("Manager Healthy !! ");
		ResponseEntity<HealthVO> response = new  ResponseEntity<>(health,HttpStatus.OK);
		return Mono.just(response);
	}
	
	

}
