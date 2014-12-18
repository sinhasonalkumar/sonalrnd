package com.sonal.executor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer3 {

	@RabbitListener(queues = "myQueue")
	public void receieveMessage(String message){
		System.out.println("DemoConsumer3 :: Receiving Message...");
		System.out.println("DemoConsumer3 :: Received  Message :: " + message);
		try {
			System.out.println("DemoConsumer3 :: Started Processing Message ....");
			Thread.sleep(3000000l);
			System.out.println("DemoConsumer3 :: Message Processing Completed Successfully ....");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
