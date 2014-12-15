package com.sonal.executor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.RabbitMQConfiguration;

public class DemoConsumer {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfiguration.class);
		AmqpTemplate template = context.getBean(AmqpTemplate.class);

		System.out.println("Receving Message...");
		while (true) {
			String message = (String) template.receiveAndConvert("myqueue");
			System.out.println("Received  Message :: " + message);
			Thread.sleep(1000l);
		}
	}

}
