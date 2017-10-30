package com.sonal.spring5.springwebreactordemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories(basePackages = { "com.sonal.spring5.springwebreactordemo.persistence" })
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
	return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
    
    @Override
    protected String getDatabaseName() {
	return "testreactive";
    } 

    @Override
    public MongoClient reactiveMongoClient() {
	return MongoClients.create();
    }
}
