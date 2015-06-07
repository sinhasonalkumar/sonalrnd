package com.sonal.config.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@Configuration
public class SpringThreadAppAsyncConfig extends AsyncConfigurerSupport{

    @Override
    public Executor getAsyncExecutor() {
	//int availableProcessors = Runtime.getRuntime().availableProcessors();
	int availableProcessors = 100;
	ExecutorService fixedThreadPoolSexecutor = Executors.newFixedThreadPool(availableProcessors);
	return fixedThreadPoolSexecutor;
    }

     
}
