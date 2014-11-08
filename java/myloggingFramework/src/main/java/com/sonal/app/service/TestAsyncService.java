package com.sonal.app.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TestAsyncService {

	@Async
	public void doSomethingAsync() throws Exception{
		System.out.println("Doing Something Async....");
		Thread.sleep(6000);
		
	}
}
