package com.sonal.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sonal.completablefuture.vo.FlatResponse;
import com.sonal.completablefuture.vo.ResponseA;
import com.sonal.completablefuture.vo.ResponseB;

public class ParallelCalls {

    public static void main(String[] args) throws Exception {
	
	String inputA = "123";
	List<String> inputB = Stream.of("Abc","Xyz").collect(Collectors.toList());
	
	CompletableFuture<ResponseA> serviceARespPromise = CompletableFuture.supplyAsync(() -> callServiceA(inputA));
	
	CompletableFuture<List<ResponseB>> serviceBStackRespPromise = callServiceStack(inputB);
	
	FlatResponse flatResponse = serviceARespPromise.thenCombine(serviceBStackRespPromise, (a, bs) -> flatServiceResponse(a, bs))
			   .get();
	
	System.out.println(flatResponse);
    }
    
    public static FlatResponse flatServiceResponse(ResponseA responseA, List<ResponseB> responsesB) {
	FlatResponse flatResponse = new FlatResponse();
	flatResponse.setResponseA(responseA);
	flatResponse.setResponsesB(responsesB);
	return flatResponse;
    }
    
    public static CompletableFuture<List<ResponseB>> callServiceStack(List<String> inputB) {
	return CompletableFuture.supplyAsync(() -> inputB.parallelStream()
		      .map(i -> callServiceB(i))
		      .collect(Collectors.toList()));
    }
    
    public static ResponseA callServiceA(String input) {
	System.out.println("Start callServiceA");
	sleep(7000);
	ResponseA responseA = new ResponseA();
	responseA.setResult("Result --> " + input);
	System.out.println("End callServiceA");
	return responseA;
    }
    
    public static ResponseB callServiceB(String input) {
	System.out.println("Start callServiceB");
	sleep(4500);
	ResponseB responseB = new ResponseB();
	responseB.setResult("Result --> " + input);
	System.out.println("End callServiceB");
	return responseB;
    }
    
    public static void sleep(long millis) {
	try {
	    Thread.sleep(millis);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    
}
