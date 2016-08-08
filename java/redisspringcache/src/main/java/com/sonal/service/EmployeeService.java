package com.sonal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sonal.dao.EmployeeDAO;
import com.sonal.vo.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    
    @Cacheable(value="allEmployees")
    public List<Employee> findAllEmployees() {
        
        List<Employee> employees = employeeDAO.findAll();
        
        return employees;
    }
    
    
    @Cacheable(value="employee",key = "#userName")
    public List<Employee> findByName(String userName) {
        
        List<Employee> employees = employeeDAO.findByUserName(userName);
        
        return employees;
    }
}
