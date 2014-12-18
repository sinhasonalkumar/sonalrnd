package com.sonal.executor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
		//RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
		String message = "Hello World !!";
		System.out.println("Sending Message...");
		template.convertAndSend("myDirectExchange","myRoutingKey1",message + "by Routing Key1");
		template.convertAndSend("myDirectExchange","myRoutingKey2",message + "by Routing Key2");
		//rabbitTemplate.convertAndSend("myDirectExchange","myRoutingKey1",message);
		
		System.out.println("Sending sent");
	}
}
