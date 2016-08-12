package com.sonal.spring5.rest.dao;

import java.util.List;

import com.sonal.spring5.rest.persistence.model.StudentBO;

import reactor.core.publisher.Mono;

public interface IStudentDAO {

    Mono<List<StudentBO>> findAll();

    Mono<StudentBO> findByUserName(String userName);

}