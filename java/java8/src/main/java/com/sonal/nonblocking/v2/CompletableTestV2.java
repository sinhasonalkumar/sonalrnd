package com.sonal.nonblocking.v2;

import java.util.concurrent.CompletableFuture;

public class CompletableTestV2 {

    public CompletableFuture<String> service1() {
	CompletableFuture<String> service1CompletableFutureResult = CompletableFuture.supplyAsync(this::service1BL);
	return service1CompletableFutureResult;
    }    

    public CompletableFuture<String> service2() {
	CompletableFuture<String> service2CompletableFutureResult = CompletableFuture.supplyAsync(this::sevice2BL);
	return service2CompletableFutureResult;
    }
    
    
    private String service1BL() {
	System.out.println("Start Service 1");
	System.out.println("Start Service 1 :: Thread :: " + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
	sleep(5000);
	System.out.println("End Service 1");
	return "Service1 Result";
    }

    private String sevice2BL() {
	System.out.println("Start Service 2");
	System.out.println("Start Service 2 :: Thread :: " + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
	sleep(2000);
	System.out.println("End Service 2");
	return "Service2 Result";
    }

    private void sleep(long millis) {
	try {
	    Thread.sleep(millis);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
