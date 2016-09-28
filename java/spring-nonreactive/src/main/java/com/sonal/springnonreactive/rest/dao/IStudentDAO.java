package com.sonal.springnonreactive.rest.dao;

import java.util.List;

import com.sonal.springnonreactive.rest.persistence.model.StudentBO;

public interface IStudentDAO {

    List<StudentBO> findAll();

    StudentBO findByUserName(String userName);

}