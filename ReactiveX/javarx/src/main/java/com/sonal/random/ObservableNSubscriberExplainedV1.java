package com.sonal.random;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import rx.Observable;
import rx.Subscriber;

public class ObservableNSubscriberExplainedV1 {

    public static void main(String[] args) {
	
	AtomicInteger messageCount = new AtomicInteger(1);
	
	Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
	    @Override
	    public void call(Subscriber<? super String> subscriber) {
		while (!subscriber.isUnsubscribed()) {
		    sleep(1000l);
		    String messageId = UUID.randomUUID().toString();
		    System.out.println("Message Pushed :: MessageId -> " + messageId);
		    subscriber.onNext(messageId);
		}
		subscriber.onCompleted();
	    }

	});
	
	observable.subscribe(new Subscriber<String>() {

	    @Override
	    public void onCompleted() {
		System.out.println("Completed !!");
		
	    }

	    @Override
	    public void onError(Throwable e) {
		System.err.println("Error Encountered" + e);
	    }

	    @Override
	    public void onNext(String messageId) {
		sleep(500l);
		System.out.println("Message Received :: MessageId " + messageId);
		System.out.println("Message Count :: " + messageCount);
		if(messageCount.get() == 10){
		  unsubscribe();
		}
		messageCount.incrementAndGet();
		
		
		
	    }
	    
	});
	
	
    }
    
    public static void sleep(long ms){
	try {
	    Thread.sleep(ms);
	} catch (InterruptedException e) {}
    }
}
