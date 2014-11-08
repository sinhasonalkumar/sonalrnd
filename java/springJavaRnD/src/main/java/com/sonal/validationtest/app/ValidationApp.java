package com.sonal.validationtest.app;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sonal.validationtest.annotation.ValidStudentVO;
import com.sonal.validationtest.vo.StudentVO;

public class ValidationApp {

	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		//cache the factory somewhere
		Validator validator = factory.getValidator();
		
		StudentVO studentVO = buildStudentVOBelow18();
		validator.validate(studentVO);
		createStudent(studentVO);
		
		
		studentVO = buildStudentVOOver18();
		createStudent(studentVO);
	}
	
	public static void createStudent(@ValidStudentVO StudentVO studentVO){
		
		System.out.println("Student Created !!");
	}
	
	private static StudentVO buildStudentVOOver18(){
		StudentVO studentVO = new StudentVO();
		studentVO.setName("ABC");
		studentVO.setAge(19);
		
		return studentVO;
	}
	
	
	private static StudentVO buildStudentVOBelow18(){
		StudentVO studentVO = new StudentVO();
		studentVO.setName("ABC");
		studentVO.setAge(16);
		
		return studentVO;
	}
}
