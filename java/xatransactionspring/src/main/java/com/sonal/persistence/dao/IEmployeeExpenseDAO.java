package com.sonal.persistence.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sonal.persistence.bo.EmployeeExpense;

public interface IEmployeeExpenseDAO extends MongoRepository<EmployeeExpense, Serializable> {

}
