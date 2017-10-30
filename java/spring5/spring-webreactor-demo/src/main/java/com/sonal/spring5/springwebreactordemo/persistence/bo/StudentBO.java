package com.sonal.spring5.springwebreactordemo.persistence.bo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document
public class StudentBO implements Serializable{

    private static final long serialVersionUID = 7268229809366806791L;
    
    @Id
    private String id;
    
    @Indexed
    private String name;
    
    private Integer age;

}
