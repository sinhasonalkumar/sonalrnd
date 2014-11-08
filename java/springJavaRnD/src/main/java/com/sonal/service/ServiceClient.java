package com.sonal.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.sonal.vo.StateVO;

@Service
@EnableAsync
public class ServiceClient {

	@Async
	public StateVO invokeClientByAsync(int noOfRecords) throws Throwable{
		System.out.println("Client Invoke Start");
		StateVO stateVO = new StateVO();
		if(noOfRecords <= 50){
			Thread.sleep(3000);
		}
		if(noOfRecords >50){
			Thread.sleep(7000);
		}
		System.out.println("Client Invoke End");
		return stateVO;
	}
	
	
	public StateVO invokeClient(int noOfRecords) throws Throwable{
		System.out.println("Client Invoke Start");
		StateVO stateVO = new StateVO();
		if(noOfRecords <= 50){
			Thread.sleep(3000);
		}
		if(noOfRecords >50){
			Thread.sleep(7000);
		}
		System.out.println("Client Invoke End");
		return stateVO;
	}
}
