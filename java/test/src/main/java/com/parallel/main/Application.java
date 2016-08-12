package com.parallel.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import com.parallel.ParallelEsecutorService;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.parallel")
public class Application {
    
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        ParallelEsecutorService bean = ctx.getBean(ParallelEsecutorService.class);
        bean.start();
        
    }

}
