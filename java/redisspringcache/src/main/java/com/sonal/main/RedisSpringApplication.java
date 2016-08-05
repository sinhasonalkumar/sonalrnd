package com.sonal.main;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sonal.service.EmployeeService;
import com.sonal.vo.Employee;

@SpringBootApplication
@ComponentScan("com.sonal")
public class RedisSpringApplication implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(RedisSpringApplication.class);
    
    @Autowired
    private EmployeeService employeeService;
    
    
    @Override
    public void run(String... arg0) throws Exception {
        List<Employee> employees = employeeService.findAllEmployees();
        
        logger.info("All Employees :: " + employees);
        
        employees = null;
        
        employees = employeeService.findAllEmployees();
        
        logger.info("All Employees :: " + employees);
        
        
        employees = employeeService.findByName("Employee1");
        
        logger.info("Find Employee1  :: " + employees);
        
        
        employees = employeeService.findByName("Employee1");
        
        logger.info("Find Employee1  :: " + employees);
        
        
        
        employees = employeeService.findByName("Employee2");
        
        logger.info("Find Employee2  :: " + employees);
        
        
        employees = employeeService.findByName("Employee2");
        
        logger.info("Find Employee2  :: " + employees);
        
        
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RedisSpringApplication.class, args);
    }

}
