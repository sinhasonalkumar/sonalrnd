package com.sonal.persistence.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sonal.persistence.bo.EmployeeBO;

public interface IEmployeeDAO extends MongoRepository<EmployeeBO, String> {

    List<EmployeeBO> findByuserName(String userName);

}
