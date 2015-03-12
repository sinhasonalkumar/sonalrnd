package com.sonal.batch.schedular;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.batch.config.BatchAppConfig;

public class BatchMain {

    public static void main(String[] args) {
   	ApplicationContext context = new AnnotationConfigApplicationContext(BatchAppConfig.class);
   	BookFeedRunner bookFeedRunner = context.getBean(BookFeedRunner.class);
   	bookFeedRunner.startBookFeedJob();
   	
       }
}
