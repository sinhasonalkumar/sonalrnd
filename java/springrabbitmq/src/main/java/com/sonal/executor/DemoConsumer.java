package com.sonal.executor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer {
	
	@RabbitListener(queues = "myqueue")
	public void receieveMessage(String message){
		System.out.println("Receving Message...");
		System.out.println("Received  Message :: " + message);
	}

}
