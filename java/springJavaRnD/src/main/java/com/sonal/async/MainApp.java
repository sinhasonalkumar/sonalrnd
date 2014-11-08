package com.sonal.async;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sonal.service.BulkRecordPullerService;

@Component
public class MainApp {

	public static void main(String[] args) throws Throwable{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		BulkRecordPullerService bulkRecordPullerService = appContext.getBean(BulkRecordPullerService.class);
		bulkRecordPullerService.pullBulkRecordsByAsyncService();
		bulkRecordPullerService.pullBulkRecordsByNormalService();
	}
}
