package com.sonal.persistence.bo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
@NamedQueries(value = { 
		@NamedQuery(name = "getAllEmplyees", query = "from Employee") 
		})
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private UUID id;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

}
