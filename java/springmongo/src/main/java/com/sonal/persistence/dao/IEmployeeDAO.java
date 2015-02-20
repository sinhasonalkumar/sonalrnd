package com.sonal.persistence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sonal.persistence.bo.Employee;

public interface IEmployeeDAO extends MongoRepository<Employee, String> {


}
