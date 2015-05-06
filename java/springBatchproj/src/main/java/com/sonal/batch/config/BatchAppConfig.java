package com.sonal.batch.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean()
    public ItemReader<List<BooksFeed>> bookFeedReader() {
	return new BookFeedItemReader();
    }

    @Bean
    public ItemProcessor<List<BooksFeed>, List<BooksForSale>> bookFeedProcessor() {
	return new BookFeedItemProcessor();
    }

    @Bean
    public ItemWriter<List<BooksForSale>> bookFeedWriter() {
	return new BookFeedItemWriter();
    }

    @Bean
    public Job bookFeederJob() {
	//Job job = jobBuilderFactory.get("Job :: BookFeederJob").flow(bookFeedJobStep1()).next(bookFeedJobStep2()).end().build();
	//Job job = jobBuilderFactory.get("Job :: BookFeederJob").start(bookFeedJobStep1()).next(bookFeedJobStep2()).build();
	Job job = jobBuilderFactory.get("Job :: BookFeederJob").incrementer(new RunIdIncrementer()).flow(bookFeedJobStep1()).end().build();
	return job;
    }
    
    @Bean
    public Step bookFeedJobStep1() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: BookFeedJob_Step1");

	TaskletStep taskletofStep1 = stepBuilder.<List<BooksFeed>, List<BooksForSale>> chunk(2)
						.reader(bookFeedReader())
						.processor(bookFeedProcessor())
						.writer(bookFeedWriter())
						.build();	

	return taskletofStep1;
    }

    /*@Bean
    public Step bookFeedJobStep1() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: BookFeedJob_Step1");

	TaskletStep taskletofStep1 = stepBuilder.<List<BooksFeed>, List<BooksForSale>> chunk(2)
						.reader(bookFeedReader())
						.processor(bookFeedProcessor())
						.writer(bookFeedWriter())
						
						.listener(new StepExecutionListener() {
						    
						    @Override
						    public void beforeStep(StepExecution stepExecution) {
							System.out.println("beforeStep");
							try {
							    Thread.sleep(6000l);
							} catch (InterruptedException e) {
							    // TODO Auto-generated catch block
							    e.printStackTrace();
							}
							
							
						    }
						    
						    @Override
						    public ExitStatus afterStep(StepExecution stepExecution) {
							System.out.println("afterStep");
							try {
							    Thread.sleep(6000l);
							} catch (InterruptedException e) {
							    // TODO Auto-generated catch block
							    e.printStackTrace();
							}
							
							return ExitStatus.COMPLETED;
						    }
						})
						.listener(new ChunkListener() {
						    
						    @Override
						    public void beforeChunk(ChunkContext context) {
							System.out.println("beforeChunk");
							try {
							    Thread.sleep(6000l);
							} catch (InterruptedException e) {
							    // TODO Auto-generated catch block
							    e.printStackTrace();
							}
							
						    }
						    
						    @Override
						    public void afterChunkError(ChunkContext context) {
							// TODO Auto-generated method stub
							
						    }
						    
						    @Override
						    public void afterChunk(ChunkContext context) {
							System.out.println("afterChunk");
							try {
							    Thread.sleep(6000l);
							} catch (InterruptedException e) {
							    // TODO Auto-generated catch block
							    e.printStackTrace();
							}
						    }
						})
						.build();	

	return taskletofStep1;
    }*/
    
    
    @Bean
    public Step bookFeedJobStep2() {

	StepBuilder stepBuilder = stepBuilderFactory.get(" Step :: BookFeedJob_Step2");

	TaskletStep taskletofStep2 = stepBuilder.tasklet(new Tasklet() {
	    
	    @Override
	    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Completing Job...");
		return RepeatStatus.FINISHED;
	    }
	})
	.build();

	return taskletofStep2;
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
