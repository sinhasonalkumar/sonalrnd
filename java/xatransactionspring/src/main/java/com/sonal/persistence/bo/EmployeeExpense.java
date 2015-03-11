package com.sonal.persistence.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

@Setter
@Getter
@EqualsAndHashCode(of = {"id","empId"})
public class EmployeeExpense implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2040184740537662037L;
    
    @Id
    private String id;
    private String empId;
    private BigDecimal expense;

}
