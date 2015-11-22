package com.sonal.iot.mqtt.demo;

import com.sonal.iot.mqtt.demo.publisher.DemoPublisher;
import com.sonal.iot.mqtt.demo.subscriber.DemoSubscriber;

public class MqttDemo {

    public static void main(String[] args) throws InterruptedException {
	Thread publisherThread = new Thread(new Runnable() {

	    @Override
	    public void run() {
		try {
		    DemoPublisher.demoPublish();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	});

	Thread subscriberThread = new Thread(new Runnable() {

	    @Override
	    public void run() {
		try {
		    DemoSubscriber.demoSubscribe();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	});

	subscriberThread.run();
	publisherThread.run();
	
	subscriberThread.join();
	publisherThread.join();
	
    }
}
