package com.sonal.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.AppCacheConfig;
import com.sonal.services.MemcachedCachedService;
import com.sonal.vo.User;

public class ProgExecutor {

    public static void main(String[] args) {
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppCacheConfig.class);
	MemcachedCachedService cachedService = applicationContext.getBean(MemcachedCachedService.class);
	
	//testAddAndGet(cachedService);
	testAddToCache(cachedService);
	System.exit(0);
    }
    
    
    public static void testAddToCache(MemcachedCachedService cachedService){
	User user1 = new User();
	user1.setUserId("userOne");
	user1.setUserId("ABC");
	
	User user2 = new User();
	user2.setUserId("userTwo");
	user2.setUserId("XYZ");

	
	cachedService.putUser(user1);
	cachedService.putUser(user1);
	cachedService.putUser(user2);
	cachedService.putUser(user2);
	
    }

    private static void testAddAndGet(MemcachedCachedService cachedService) {
	User user = new User();
	user.setUserId("user1");
	user.setUserId("ABC");
	
	if(cachedService.getUser(user.getUserId()) != null){
	    System.out.println("Hit");
	}else{
	    System.out.println("Miss");
	}
	
	cachedService.putUser(user);
	
	if(cachedService.getUser(user.getUserId()) != null){
	    System.out.println("Hit");
	}else{
	    System.out.println("Miss");
	}
    }

}
