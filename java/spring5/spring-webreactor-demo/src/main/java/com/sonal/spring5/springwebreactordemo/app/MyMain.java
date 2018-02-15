package com.sonal.spring5.springwebreactordemo.app;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MyMain {
    
    public static void main(String[] args) throws InterruptedException {
	
	/*Flux.zip(serviceA(), serviceB(),serviceC())
	    .map(aggResult -> aggregateResult(aggResult.getT1(),aggResult.getT2(),aggResult.getT3()))
	    .subscribe(o -> System.out.println(o)); 
	
	serviceA().mergeWith(serviceB())
		  .subscribe(System.out :: println);
	
	serviceA().concat(serviceB())
		  .subscribe(System.out :: println);*/ 
	
	List<String> name = new ArrayList<String>();
	name.add("abc");
	name.add("xyz");
	
	
	
	Flux.defer(() -> Flux.fromIterable(name))
	    .subscribeOn(Schedulers.elastic())
	    .subscribe(o -> System.out.println(o));
	
	
	Thread.sleep(100000l);
    }
    
    public static Flux<String> serviceA() {
	return Flux.interval(Duration.ofSeconds(1L))
		   .flatMap(i -> Mono.just("Servive A : " + UUID.randomUUID().toString() + "-->" + i));
    }
    
    public static Flux<String> serviceB() {
   	return Flux.interval(Duration.ofSeconds(2L))
   		   .flatMap(i -> Mono.just("Servive B : " + UUID.randomUUID().toString() + "-->" + i));
    }
    
    public static Flux<String> serviceC() {
   	return Flux.interval(Duration.ofSeconds(3L))
   		   .flatMap(i -> Mono.just("Servive C : " + UUID.randomUUID().toString() + "-->" + i));
    }
    
    public static String aggregateResult(String a, String b, String c) {
	String result = a + b + c;
	System.out.println(result);
	return result;
    }

}
