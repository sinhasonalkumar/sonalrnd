package com.logback.config;

import java.util.concurrent.Executor;

import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.logback.rest.controller.interceptor.ControllerInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ControllerInterceptor getControllerInterceptor() {
	ControllerInterceptor c = new ControllerInterceptor();
	return c;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(getControllerInterceptor()).addPathPatterns("/**");
	super.addInterceptors(registry);
    }

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
	return new ThreadPoolTaskExecutor();
    }

    @Bean
    public AmazonSNSClient amazonSNSClient() {
	AmazonSNSClient snsClient = new AmazonSNSClient();
	snsClient.setRegion(Region.getRegion(Regions.US_WEST_2));
	return snsClient;
    }

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate() {
	NotificationMessagingTemplate notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSNSClient());
	return notificationMessagingTemplate;
    }

}
