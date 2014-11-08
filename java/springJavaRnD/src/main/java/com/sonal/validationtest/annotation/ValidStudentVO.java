package com.sonal.validationtest.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.sonal.validationtest.validator.CreateStudentValidator;


@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.ANNOTATION_TYPE}) 
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CreateStudentValidator.class)
public @interface ValidStudentVO {

	String message() default "Not a valid student to create !!";
}
