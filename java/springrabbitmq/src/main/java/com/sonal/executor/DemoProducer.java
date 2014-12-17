package com.sonal.executor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.RabbitMQConfiguration;

public class DemoProducer {

	public static void main(String[] args) throws Throwable{
		while(true){
			sendMessage();
			Thread.sleep(3000l);
		}
		
	}

	private static void sendMessage() {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfiguration.class);
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		String message = "Hello World !!";
		System.out.println("Sending Message...");
		template.convertAndSend("myqueue", message);
		System.out.println("Sending sent");
	}
}
