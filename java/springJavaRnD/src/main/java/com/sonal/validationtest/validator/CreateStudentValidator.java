package com.sonal.validationtest.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sonal.validationtest.annotation.ValidStudentVO;
import com.sonal.validationtest.vo.StudentVO;

public class CreateStudentValidator implements ConstraintValidator<ValidStudentVO,StudentVO> {

	@Override
	public void initialize(ValidStudentVO constraintAnnotation) {
		System.out.println("public void initialize(ValidStudentVO constraintAnnotation)");		
		

	}

	@Override
	public boolean isValid(StudentVO student, ConstraintValidatorContext context) {
		System.out.println("Entered public boolean isValid(StudentVO student, ConstraintValidatorContext context)");
		boolean valid = false;
		if(student.getAge() >= 18){
			valid = true;
		}
		return valid;
	}

	

	
}
