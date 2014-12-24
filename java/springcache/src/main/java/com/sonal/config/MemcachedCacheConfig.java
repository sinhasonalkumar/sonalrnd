package com.sonal.config;



import java.util.HashSet;
import java.util.Set;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.CacheConfiguration;
import com.google.code.ssm.providers.spymemcached.MemcacheClientFactoryImpl;
import com.google.code.ssm.spring.SSMCache;
import com.google.code.ssm.spring.SSMCacheManager;

@Configuration
@ComponentScan(basePackages = { "com.sonal" })
public class MemcachedCacheConfig {

	@Bean
	public CacheManager chacheManager() {
		SSMCacheManager cacheManager = new SSMCacheManager();
		
		Set<SSMCache> caches = new HashSet<SSMCache>();
		
		Cache defaultCache = null;
		Cache nameCache = null;
		try {
			
			defaultCache = defaultCacheFactory().getObject();
			nameCache = nameCacheFactory().getObject();
			System.out.println(defaultCache.getName());
			System.out.println(nameCache.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SSMCache defaultSSMCache = new SSMCache(defaultCache, 300,false);
		SSMCache nameSSMCache = new SSMCache(nameCache, 300,false);
		
		caches.add(defaultSSMCache);
		caches.add(nameSSMCache);
		
		cacheManager.setCaches(caches);
		
		return cacheManager;
	}
	
	@Bean
	public CacheFactory defaultCacheFactory(){
		CacheFactory cacheFactory = new CacheFactory();
		cacheFactory.setCacheName("default");
		cacheFactory.setCacheClientFactory(cacheClientFactory());
		cacheFactory.setAddressProvider(addressProvider());
		cacheFactory.setConfiguration(cacheConfiguration());
		return cacheFactory;
	}
	
	@Bean
	public CacheFactory nameCacheFactory(){
		CacheFactory cacheFactory = new CacheFactory();
		cacheFactory.setCacheName("nameCache");
		cacheFactory.setCacheClientFactory(cacheClientFactory());
		cacheFactory.setAddressProvider(addressProvider());
		cacheFactory.setConfiguration(cacheConfiguration());
		return cacheFactory;
	}

	@Bean
	public MemcacheClientFactoryImpl cacheClientFactory() {
		return new MemcacheClientFactoryImpl();
	}

	@Bean
	public DefaultAddressProvider addressProvider() {
		DefaultAddressProvider defaultAddressProvider = new DefaultAddressProvider();
		defaultAddressProvider.setAddress("127.0.0.1:11211");
		return defaultAddressProvider;
	}
	
	@Bean
	public CacheConfiguration cacheConfiguration(){
		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		cacheConfiguration.setConsistentHashing(true);
		cacheConfiguration.setUseBinaryProtocol(true);
		return cacheConfiguration;
	}
}
