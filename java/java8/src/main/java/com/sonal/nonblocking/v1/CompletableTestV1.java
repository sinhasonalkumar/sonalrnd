package com.sonal.nonblocking.v1;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompletableTestV1 {

    public static void main(String[] args) throws Exception {

	System.out.println("Main :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
	CompletableTestV1 completableTest = new CompletableTestV1();
	CompletableFuture<String> service1 = completableTest.service1().handleAsync(new BiFunction<String, Throwable, String>() {
	    @Override
	    public String apply(String t, Throwable u) {
		System.out.println("service1 :: handleAsync :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
		String result = null;
		if (u != null) {
		    result = "Service1 Error :: " + u.getMessage();
		}else{
		    result = t;
		}
		return result;
	    }

	});
	CompletableFuture<String> service2 = completableTest.service2().handleAsync(new BiFunction<String, Throwable, String>() {
	    @Override
	    public String apply(String t, Throwable u) {
		System.out.println("service2 :: handleAsync :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
		String result = null;
		if (u != null) {
		    result = "Service2 Error :: " + u.getMessage();
		}else{
		    result = t;
		}
		return result;
	    }

	});

	BiFunction<String, String, String> aggregationOfService1NService2Functuion = new BiFunction<String, String, String>() {
	    @Override
	    public String apply(String service1Result, String service2Result) {
		System.out.println("BiFunction :: apply :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
		return service1Result + " :: " + service2Result;
	    }
	};

	CompletableFuture<String> aggregateCompletableFuture = service1.thenCombineAsync(service2, aggregationOfService1NService2Functuion).handleAsync(new BiFunction<String, Throwable, String>() {
	    @Override
	    public String apply(String aggregationOfService1NService2Result, Throwable u) {
		System.out.println("aggregateCompletableFuture :: thenCombineAsync :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
		String result = null;
		
		if(u != null){
		    result = aggregationOfService1NService2Result + " :: With aggregation Error";
		}else{
		    result = aggregationOfService1NService2Result;
		}

		return result;
	    }

	});

	aggregateCompletableFuture.thenAcceptAsync(new Consumer<String>() {
	    @Override
	    public void accept(String aggregationOfService1NService2Result) {
		System.out.println(aggregationOfService1NService2Result);
	    }
	}).join();

    }

    public CompletableFuture<String> service1() {
	CompletableFuture<String> service1CompletableFutureResult = CompletableFuture.supplyAsync(new Supplier<String>() {

	    @Override
	    public String get() {
		System.out.println("Start Service 1");
		System.out.println("Start Service 1 :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("End Service 1");

		return "Service1 Result";
	    }

	});

	return service1CompletableFutureResult;
    }

    public CompletableFuture<String> service2() {
	CompletableFuture<String> service2CompletableFutureResult = CompletableFuture.supplyAsync(new Supplier<String>() {

	    @Override
	    public String get() {
		System.out.println("Start Service 2");
		System.out.println("Start Service 2 :: Thread ::" + Thread.currentThread().getId() + " :: " + Thread.currentThread().getName());
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		//System.out.println(0 / 0);
		System.out.println("End Service 2");
		return "Service2 Result";
	    }

	});

	return service2CompletableFutureResult;
    }

    public void allOfTest() {
	CompletableTestV1 completableTest = new CompletableTestV1();
	final CompletableFuture<String> service1 = completableTest.service1();
	final CompletableFuture<String> service2 = completableTest.service2();

	CompletableFuture.allOf(service1, service2).thenRun(new Runnable() {

	    @Override
	    public void run() {
		String service1Result = null;
		String service2Result = null;
		try {
		    service1Result = service1.get();
		} catch (InterruptedException | ExecutionException e) {
		}

		try {

		    service2Result = service2.get();
		} catch (InterruptedException | ExecutionException e) {
		}

		System.out.println("Aggregate Result Of Service1 and Service 2 :: " + service1Result + " :: " + service2Result);
		System.out.println("Done with Long Runnig Work");

	    }
	}).join();
    }

}
