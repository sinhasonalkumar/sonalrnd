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
        
        System.out.println("@@@@@@@@@@@@@@@ Start First  Execution @@@@@@@@@@@@@@@@@@");
        
        serviceFacade.doComplexFeature();
        
        System.out.println("@@@@@@@@@@@@@@@ End First  Execution @@@@@@@@@@@@@@@@@@");
        
        Thread.sleep(500);
        
        System.out.println("@@@@@@@@@@@@@@@ Start Second Execution @@@@@@@@@@@@@@@@@@");
        
        serviceFacade.doComplexFeature();
        
        System.out.println("@@@@@@@@@@@@@@@ End Second  Execution @@@@@@@@@@@@@@@@@@");
        
    }
}

