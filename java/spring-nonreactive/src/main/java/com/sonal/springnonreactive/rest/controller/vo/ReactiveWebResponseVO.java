package com.sonal.springnonreactive.rest.controller.vo;

import java.util.List;

import com.sonal.springnonreactive.rest.persistence.model.StudentBO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames = true)
public class ReactiveWebResponseVO {

    private String message;

    private List<StudentBO> students;

    private StudentBO student;
    
    private String passportNo;
}
