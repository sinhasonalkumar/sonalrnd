package com.sonal.springjavarx.rest.dao;

import java.util.List;

import com.sonal.springjavarx.rest.persistence.model.StudentBO;

import rx.Observable;

public interface IStudentDAO {

    Observable<List<StudentBO>> findAll();

    Observable<StudentBO> findByUserName(String userName);

}