package com.sonal.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
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
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
		return rabbitAdmin;
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		//rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Queue createMyQueue() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("x-dead-letter-exchange", "myDirectExchange.myDeadLetterExchange");
		args.put("x-max-length", 2);
		Queue queue = new Queue("myQueue",true, false, false, args);
		return queue;
	}
	
	@Bean
	public Queue createMyQueueDeadLettered() {
		Map<String, Object> args = new HashMap<String, Object>();
		Queue queue = new Queue("myQueue.deadLettered",true, false, false, args);
		return queue;
	}
	
	@Bean
	public DirectExchange createMyDirectExchange(){
		Map<String, Object> args = new HashMap<String, Object>();
		DirectExchange directExchange = new DirectExchange("myDirectExchange",true,false,args);
		return directExchange;
	}
	
	@Bean
	public FanoutExchange createMyDeadLetterExchange(){
		Map<String, Object> args = new HashMap<String, Object>();
		FanoutExchange fanoutExchange = new FanoutExchange("myDirectExchange.myDeadLetterExchange",true,false,args);
		return fanoutExchange;
	}
	
	@Bean
	public Binding createMyBinding1(){
		String myRoutingKey1 = "myRoutingKey1";
		Map<String, Object> args = new HashMap<String, Object>();
		Binding binding = BindingBuilder.bind(createMyQueue()).to(createMyDirectExchange()).with(myRoutingKey1);
		return binding;
	}
	
	@Bean
	public Binding createMyBinding2(){
		String myRoutingKey2 = "myRoutingKey2";
		Map<String, Object> args = new HashMap<String, Object>();
		Binding binding = BindingBuilder.bind(createMyQueue()).to(createMyDirectExchange()).with(myRoutingKey2);
		return binding;
	}
	
	@Bean
	public Binding createMyDeadletterBinding(){
		Map<String, Object> args = new HashMap<String, Object>();
		Binding binding = BindingBuilder.bind(createMyQueueDeadLettered()).to(createMyDeadLetterExchange());
		return binding;
	}
	
	
	/*@Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }*/

}
