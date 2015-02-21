package com.sonal.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.MemcachedCacheConfig;
import com.sonal.services.CachedService;
import com.sonal.vo.User;

public class ProgExecutor {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MemcachedCacheConfig.class);
		CachedService cachedService = applicationContext.getBean(CachedService.class);

		 computeFullName(cachedService);

		cacheUserData(cachedService);

	}

	private static void cacheUserData(CachedService cachedService) {
		User user1 = new User();
		user1.setUserId("123");
		user1.setUserName("test1");

		User user2 = new User();
		user2.setUserId("234");
		user2.setUserName("test2");

		String cacheKey = user1.getUserId();

		user1 = cachedService.cacheSomeUserData(user1);
		System.out.println(user1.getUserName());
		user1 = cachedService.cacheSomeUserData(user1);
		System.out.println(user1.getUserName());
		user1 = cachedService.cacheSomeUserData(user1);
		System.out.println(user1.getUserName());

		cacheKey = user2.getUserId();
		user2 = cachedService.cacheSomeUserData(user2);
		System.out.println(user2.getUserName());
		user2 = cachedService.cacheSomeUserData(user2);
		System.out.println(user2.getUserName());
		user2 = cachedService.cacheSomeUserData(user2);
		System.out.println(user2.getUserName());
	}

	private static void computeFullName(CachedService cachedService) {
		System.out.println(cachedService.computeFullName("1", "sonal", "sinha", "kumar"));
		System.out.println(cachedService.computeFullName("1", "sonal", "sinha", "kumar"));
	}
}
