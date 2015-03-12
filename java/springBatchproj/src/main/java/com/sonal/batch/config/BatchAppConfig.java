package com.sonal.batch.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sonal.batch.persistence.bo.BooksForSale;
import com.sonal.batch.service.BookFeedItemProcessor;
import com.sonal.batch.service.BookFeedItemReader;
import com.sonal.batch.service.BookFeedItemWriter;
import com.sonal.batch.vo.BooksFeed;

@Configuration
@ComponentScan(basePackages = { "com.sonal" })
@EnableBatchProcessing
public class BatchAppConfig {

    @Bean
    public ItemReader<List<BooksFeed>> reader() {
	return new BookFeedItemReader();
    }

    @Bean
    public ItemProcessor<List<BooksFeed>, List<BooksForSale>> processor() {
	return new BookFeedItemProcessor();
    }

    @Bean
    public ItemWriter<List<BooksForSale>> writer() {
	return new BookFeedItemWriter();
    }

    @Bean
    public Job bookFeedJob(JobBuilderFactory jobs, Step s1) {
	Job job = jobs.get("bookFeedJob").start(s1).build();
	return job;
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<List<BooksFeed>> reader, ItemWriter<List<BooksForSale>> writer, ItemProcessor<List<BooksFeed>, List<BooksForSale>> processor) {
	TaskletStep taskletofStep1 = stepBuilderFactory.get("step1").<List<BooksFeed>, List<BooksForSale>> chunk(2).reader(reader).processor(processor).writer(writer).build();
	return taskletofStep1;
    }

    @Bean
    public ResourcelessTransactionManager transactionManager() {
	ResourcelessTransactionManager resourcelessTransactionManager = new ResourcelessTransactionManager();
	return resourcelessTransactionManager;
    }

    @Bean
    public JobRepository jobRepository() {
	MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean();
	mapJobRepositoryFactoryBean.setTransactionManager(transactionManager());
	JobRepository jobRepository = null;
	try {
	    jobRepository = mapJobRepositoryFactoryBean.getObject();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return jobRepository;
    }

    @Bean
    public SimpleJobLauncher jobLauncher() {
	SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
	simpleJobLauncher.setJobRepository(jobRepository());
	return simpleJobLauncher;
    }

}
