package com.sonal.dao;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sonal.vo.Employee;



@Component
public class EmployeeDAO {

    private final Logger logger = LoggerFactory.getLogger(EmployeeDAO.class);
    
    public List<Employee> findAll(){
        
        logger.info("************************************** Going to Fetch From DB :: AllEmployees ******************************************");
        
        Employee employee =  new Employee();
        employee.setName("Employee1");
        
       List<Employee> employees = Arrays.asList(employee);
       return employees;
    }
    
    
 public List<Employee> findByUserName(String userName){
        
        logger.info("**************************************  Going to Fetch From DB :: User " + userName + "************************************** ");
        
        Employee employee =  new Employee();
        if(userName.equals("Employee1"))
            employee.setName("Employee1");
        else
            employee.setName("Employee2");
        
       List<Employee> employees = Arrays.asList(employee);
       return employees;
    }
   
}
