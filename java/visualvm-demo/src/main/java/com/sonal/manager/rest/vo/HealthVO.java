package com.sonal.manager.rest.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HealthVO {
	
	private String status;

	public HealthVO(){};
	
	public HealthVO(String status) {
		super();
		this.status = status;
	}
	
	  
}
