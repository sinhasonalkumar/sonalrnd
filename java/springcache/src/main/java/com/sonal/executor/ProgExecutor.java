package com.sonal.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.MemcachedCacheConfig;
import com.sonal.services.CachedService;


public class ProgExecutor {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MemcachedCacheConfig.class);
		CachedService cachedService = applicationContext.getBean(CachedService.class);
		
		System.out.println(cachedService.computeFullName("1", "sonal", "sinha", "kumar"));
		System.out.println(cachedService.computeFullName("1", "sonal", "sinha", "kumar"));
		
	}
}
