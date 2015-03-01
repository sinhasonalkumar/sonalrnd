package com.sonal.config;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.sonal" })
public class AppCacheConfig {

    @Bean
    public MemcachedClient memcacheClient() {
	MemcachedClient memcachedClient = null;
	List<String> chacheServer = new ArrayList<String>();
	chacheServer.add("127.0.0.1:11211");
	List<InetSocketAddress> addresses = AddrUtil.getAddresses(chacheServer);
	try {
	    memcachedClient = new MemcachedClient(addresses);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return memcachedClient;
    }

}
