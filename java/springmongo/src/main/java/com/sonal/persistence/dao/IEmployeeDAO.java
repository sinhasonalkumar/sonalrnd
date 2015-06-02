package com.sonal.persistence.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sonal.persistence.bo.Employee;

public interface IEmployeeDAO extends MongoRepository<Employee, String> {

    List<Employee> findByuserName(String userName);

}
