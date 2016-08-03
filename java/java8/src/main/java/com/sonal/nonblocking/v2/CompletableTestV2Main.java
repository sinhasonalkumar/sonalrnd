package com.sonal.nonblocking.v2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class CompletableTestV2Main {

    public static void main(String[] args) throws InterruptedException {

	System.out.println("Main :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
	
	ForkJoinPool pool = new ForkJoinPool(50);

	pool.submit(CompletableTestV2Main::executeWorkFlow);

	pool.shutdown();	

	pool.awaitTermination(1, TimeUnit.MINUTES);

    }

    private static void executeWorkFlow() {
	
	CompletableTestV2 completableTest = new CompletableTestV2();
	
	completableTest.service1()
		       .thenCombineAsync(completableTest.service2(), CompletableTestV2Main::combineServiceBL)
		       .thenAcceptAsync(CompletableTestV2Main::performSomeActionOnCombinedResult)
		       .join();
    }

    private static String performSomeActionOnCombinedResult(String aggregationOfService1NService2Result) {
	System.out.println("thenCombineAsync  :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
	String finalResult = aggregationOfService1NService2Result + " :: Action Performed ";
	System.out.println(finalResult);
	return finalResult;
    }

    private static String combineServiceBL(String service1Result, String service2Result) {
	System.out.println("BiFunction :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
	String combinedResultAsString = "Combined Result of Service1 And Service 2 :: " + service1Result + " + " + service2Result;
	return combinedResultAsString;
    }
}
;