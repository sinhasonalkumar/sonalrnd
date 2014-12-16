package com.sonal.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory.CacheMode;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
@ComponentScan(basePackages = { "com.sonal" })
public class RabbitMQConfiguration {

	//There is Routing Connection Factory also (org.springframework.amqp.rabbit.connection.SimpleRoutingConnectionFactory)
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		//connectionFactory.setHost("127.0.0.1");
		//connectionFactory.setPort(port);
		//connectionFactory.setVirtualHost(virtualHost);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		
		//default cache size for channels is 1
		//connectionFactory.setChannelCacheSize(25);
		
		//The default cache mode is CHANNEL
		//connectionFactory.setCacheMode(CacheMode.CONNECTION);
		

		return connectionFactory;
	}
	
	@Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrentConsumers(2);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}

	@Bean
	public Queue myQueue() {
		return new Queue("myqueue");
	}

}
