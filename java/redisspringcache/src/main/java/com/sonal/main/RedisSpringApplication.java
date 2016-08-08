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
        
        logger.info("\n \n \n");
        
        while(true){
            
            findAndprintAllEmployees();
            logger.info("------------------------------------------------------");
            findAndprintEmployee();
            
            Thread.sleep(3000);
            
            logger.info("\n \n");
        }
        
        


    }

    private void findAndprintEmployee() {
        List<Employee> employees;
        logger.info("Going To Find Employee");
        employees = employeeService.findByName("Employee1");
        logger.info("Found Employee1  :: " + employees);
        
        employees = employeeService.findByName("Employee2");
        logger.info("Found Employee1  :: " + employees);
    }

    private void findAndprintAllEmployees() {
        List<Employee> employees;
        logger.info("Going To Find AllEmployees");
        employees = employeeService.findAllEmployees();
        logger.info("Found All Employees :: " + employees);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RedisSpringApplication.class, args);
    }

}
