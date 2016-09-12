package com.sonal.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sonal.springcloud.filter.ZuulProxyFilter;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan("com.sonal.springcloud")
public class ZuulProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyApplication.class, args);
    }
    
    @Bean
    public ZuulProxyFilter zuulProxyFilter() {
      return new ZuulProxyFilter();
    }

}
