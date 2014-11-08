package com.sonal.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestPostConstruct {
	
	@Value(value="test")
	private String field1;
	private String field2;
	
	@PostConstruct
	private void initFiled2(){
		field2 = field1 + "worked !!";
	}
	
	public String getField2(){
		return field2;
	}
}
