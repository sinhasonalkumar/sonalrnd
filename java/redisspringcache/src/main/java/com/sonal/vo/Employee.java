package com.sonal.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true)
public class Employee implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6692865364244529213L;
    
    private String name;
}
