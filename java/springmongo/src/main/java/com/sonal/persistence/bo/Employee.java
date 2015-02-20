package com.sonal.persistence.bo;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

@Setter
@Getter
public class Employee {

	@Id
	private String id;
	private String employeeName;
	private int age;

}
