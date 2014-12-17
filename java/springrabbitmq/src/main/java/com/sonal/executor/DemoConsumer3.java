package com.sonal.executor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer3 {

	@RabbitListener(queues = "myqueue")
	public void receieveMessage(String message){
		System.out.println("DemoConsumer3 :: Receiving Message...");
		System.out.println("DemoConsumer3 :: Received  Message :: " + message);
	}
}
