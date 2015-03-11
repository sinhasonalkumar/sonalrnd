package com.sonal.persistence.bo;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
@EqualsAndHashCode(of = {"id"})
@NamedQueries(value = { @NamedQuery(name = "getAllEmplyees", query = "from Employee") })
public class Employee implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4617026557802767135L;

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "EMPLOYEE_ID")
    private UUID id;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

}
