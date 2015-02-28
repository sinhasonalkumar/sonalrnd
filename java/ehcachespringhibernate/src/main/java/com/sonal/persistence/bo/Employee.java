package com.sonal.persistence.bo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
@NamedQueries(value = { @NamedQuery(name = "getAllEmplyees", query = "from Employee") })
@Cache(region = "com.sonal.persistence.bo.Employee",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "EMPLOYEE_ID")
    private UUID id;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

}
