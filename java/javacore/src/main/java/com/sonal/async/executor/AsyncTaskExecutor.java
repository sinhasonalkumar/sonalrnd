package com.sonal.async.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sonal.async.CallableExampleTask;

public class AsyncTaskExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		CallableExampleTask callableExampleTask = new CallableExampleTask();
		callableExampleTask.setImagePath("TestImage.jpg");
		
		Future<String> callableExampleTaskFutureResult = executorService.submit(callableExampleTask);
		System.out.println("CallableExampleTask status :: Submitted" );
		while(!callableExampleTaskFutureResult.isDone()){
			System.out.println("Checking for callableExampleTask status :: InProgress" );
			Thread.sleep(900l);
		}
		
		System.out.println("Checking for callableExampleTask status :: Completed" );
		
		String callableExampleTaskResult = callableExampleTaskFutureResult.get();
		System.out.println("Result Of callableExampleTask :: " + callableExampleTaskResult);
	}
}
