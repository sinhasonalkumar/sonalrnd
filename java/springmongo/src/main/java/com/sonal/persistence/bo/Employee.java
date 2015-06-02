package com.sonal.persistence.bo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@EqualsAndHashCode(of = {"userName"})
@Document
public class Employee {

	@Id
	private String id;
	
	@Version
	private Long version; 
	
	@Indexed(unique = true)
	private String userName;
	
	private String employeeName;
	
	private int age;
	
	private int noOfHoldingTasks;

}
