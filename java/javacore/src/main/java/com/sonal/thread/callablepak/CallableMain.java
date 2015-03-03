package com.sonal.thread.callablepak;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

    public static void main(String[] args) {

	CallableTask callableTask = new CallableTask();

	ExecutorService executorService = Executors.newCachedThreadPool();
	
	MyCallableDummnyVO myCallableDummnyVO = null;

	Future<MyCallableDummnyVO> futureResponse = executorService.submit(callableTask);
	
	System.out.println("Task Submitted ...");

	executorService.shutdown();

	
	while (true) {
	    if (futureResponse.isDone()) {
		try {
		     myCallableDummnyVO = futureResponse.get();
		    break;
		} catch (InterruptedException e) {
		    e.printStackTrace();
		    break;
		} catch (ExecutionException e) {
		    System.out.println("Exception Caught :: " + e.getMessage());
		    break;
		}
	    }
	    try {
		Thread.sleep(10);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	
	if(myCallableDummnyVO != null){
	    System.out.println("Callable Demo :: " +  myCallableDummnyVO.getMessage());
	}else{
	    System.out.println("Callable Demo :: Failed");
	}
	System.out.println("Task Completed ...");

    }
}
