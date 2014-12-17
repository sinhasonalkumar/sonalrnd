package com.sonal.executor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.RabbitMQConfiguration;

public class DemoProducer {

	public static void main(String[] args) throws Throwable{
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfiguration.class);
		
		while(true){
			sendMessage(context);
			Thread.sleep(3000l);
		}
		
	}

	private static void sendMessage(ApplicationContext context) {
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		String message = "Hello World !!";
		System.out.println("Sending Message...");
		template.convertAndSend("myqueue", message);
		System.out.println("Sending sent");
	}
}
