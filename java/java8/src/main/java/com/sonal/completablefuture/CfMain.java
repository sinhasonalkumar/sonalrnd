package com.sonal.completablefuture;

import java.util.concurrent.CompletableFuture;

import com.sonal.streamncompfut.vo.ServiceRequestVO;
import com.sonal.streamncompfut.vo.ServiceResponseVO;

public class CfMain {

    public static void main(String[] args) {
	
	//callBlockingServiceAsNonBlocking();
	
	callAsNonBlocking();
    }

    private static void callAsNonBlocking() {
	SomeNonBlockingService service = new SomeNonBlockingService();
	
	service.doSomethingStep1(new ServiceRequestVO("1"))
	       .thenCompose(r -> service.doSomethingStep1(new ServiceRequestVO(r.getResult())))
	       .thenAccept(r -> {System.out.println(r.getResult());})
	       .join();
    }

    private static void callBlockingServiceAsNonBlocking() {
	SomeBlockingService service = new SomeBlockingService();
	
	CompletableFuture<ServiceResponseVO> cf = CompletableFuture.supplyAsync(() -> service.doSomethingStep1(new ServiceRequestVO("1")));
	
	CompletableFuture<ServiceResponseVO> cfNext = cf.thenCompose( o -> CompletableFuture.supplyAsync(() -> service.doSomethingStep1(new ServiceRequestVO(o.getResult()))));
		
	
	cfNext.thenAccept(o -> {System.out.println(o.getResult());}).join();
    }
}
