package com.sonal.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OperationInput {

    private Integer x;
    
    private Integer y;
    
    private OperationType operationType;

    public static OperationInput  getInstance(Integer x, Integer y, OperationType operationType) {
	OperationInput operationInput = new OperationInput();
	operationInput.setX(x);
	operationInput.setY(y);
	operationInput.setOperationType(operationType);
	return operationInput;
    }
    
}
