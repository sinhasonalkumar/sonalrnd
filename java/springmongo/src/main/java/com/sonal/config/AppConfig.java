package com.sonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.mongodb.WriteConcern;

@Configuration
@ComponentScan(basePackages = { "com.sonal" })
@EnableMongoRepositories(basePackages = { "com.sonal.persistence.dao" })
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public MongoFactoryBean mongoFactoryBean()  {
		MongoFactoryBean mongoFactoryBean = new MongoFactoryBean();
		mongoFactoryBean.setHost("127.0.0.1");
		mongoFactoryBean.setPort(27017);
		return mongoFactoryBean;
	}

//	@Bean
//	public MongoClient mongo() throws Exception {
//		MongoClient client = new MongoClient("127.0.0.1");
//		client.setWriteConcern(WriteConcern.SAFE);
//		return client;
//	}

	@Bean
	public MongoTemplate mongoTemplate() {
		Mongo mongo = null;
		try {
			mongo = mongoFactoryBean().getObject();
			// mongo = mongo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String databaseName = "studentDB";
		MongoTemplate mongoTemplate = new MongoTemplate(mongo, databaseName);
		return mongoTemplate;
	}

}
