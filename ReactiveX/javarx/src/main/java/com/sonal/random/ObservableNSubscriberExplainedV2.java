package com.sonal.random;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import rx.Observable;
import rx.Subscriber;

public class ObservableNSubscriberExplainedV2 {

    public static void main(String[] args) {

	AtomicInteger messageCount = new AtomicInteger(1);

	// Observable<String> observable = Observable.create((Subscriber<? super String> subscriber) -> publishMessage(subscriber));

	Observable<String> observable = Observable.create(ObservableNSubscriberExplainedV2::publishMessage);

	observable.subscribe(getMessageSubscriber(messageCount));

	messageCount = resetMessageCount();

	
	observable.subscribe(getMessageSubscriber(messageCount));

	messageCount = resetMessageCount();

	
	
	observable.subscribe(getMessageSubscriber(messageCount));

    }

    private static AtomicInteger resetMessageCount() {
	AtomicInteger messageCount;
	System.out.println("\n \n Waiting For Another Subscriber");
	sleep(3000l);
	System.out.println("Another Subscriber Came \n \n ");
	messageCount = new AtomicInteger(1);
	return messageCount;
    }

    private static void publishMessage(Subscriber<? super String> subscriber) {
	while (!subscriber.isUnsubscribed()) {
	    sleep(1000l);
	    String messageId = UUID.randomUUID().toString();
	    System.out.println("Message Pushed :: MessageId -> " + messageId);
	    subscriber.onNext(messageId);
	}
	subscriber.onCompleted();
    }

    private static Subscriber<String> getMessageSubscriber(AtomicInteger messageCount) {
	return new Subscriber<String>() {

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
		sleep(1000l);
		System.out.println("Message Received :: MessageId " + messageId);
		System.out.println("Message Count :: " + messageCount);
		if (messageCount.get() == 5) {
		    unsubscribe();
		}
		messageCount.incrementAndGet();
	    }
	};
    }

    public static void sleep(long ms) {
	try {
	    Thread.sleep(ms);
	} catch (InterruptedException e) {
	}
    }
}
