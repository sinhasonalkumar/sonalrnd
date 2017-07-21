package com.sonal.streamncompfut.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceRequestVO {
    
    private String input;
    
    public ServiceRequestVO() {
	// TODO Auto-generated constructor stub
    }
    
    public ServiceRequestVO(String input) {
	this.input = input;
    }

    
}
