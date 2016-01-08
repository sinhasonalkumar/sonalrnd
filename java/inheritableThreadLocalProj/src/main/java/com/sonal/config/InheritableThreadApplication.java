package com.sonal.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sonal.service.parent.ServiceFacade;


@Configurable
@SpringBootApplication
@ComponentScan(basePackages="com.sonal")
public class InheritableThreadApplication {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext appContext = SpringApplication.run(InheritableThreadApplication.class, args);
        
        ServiceFacade serviceFacade = appContext.getBean(ServiceFacade.class);
        
        serviceFacade.doComplexFeature();
        
        Thread.sleep(500);
        
        serviceFacade.doComplexFeature();
        
    }
}

