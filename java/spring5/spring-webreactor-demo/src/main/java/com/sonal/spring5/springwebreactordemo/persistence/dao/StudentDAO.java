package com.sonal.spring5.springwebreactordemo.persistence.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sonal.spring5.springwebreactordemo.persistence.bo.StudentBO;

public interface StudentDAO extends ReactiveMongoRepository<StudentBO, String> {

}
