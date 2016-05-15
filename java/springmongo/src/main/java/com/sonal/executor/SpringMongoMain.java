package com.sonal.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sonal.config.AppConfig;
import com.sonal.persistence.bo.BookBO;
import com.sonal.persistence.bo.EmployeeBO;
import com.sonal.persistence.bo.SubjectBO;
import com.sonal.service.IEmployeeService;

public class SpringMongoMain {

    public static void main(String[] args) {
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	IEmployeeService employeeService = applicationContext.getBean(IEmployeeService.class);
	

	//generateSampleEmplaoyeeData(employeeService);
    }

    private static void generateSampleEmplaoyeeData(IEmployeeService employeeService) {

	List<EmployeeBO> employees = new ArrayList<EmployeeBO>();
	EmployeeBO employeeToSave = null;
	for (int i = 0; i <= 1000; i++) {
	    employeeToSave = new EmployeeBO();
	    Random rn = new Random();
	    int randomNumber = rn.nextInt(5) + 1;

	    BookBO bookBO = null;
	    List<BookBO> books = new ArrayList<BookBO>();
	    for (int j = 1; j <= randomNumber; j++) {
		bookBO = new BookBO();
		bookBO.setBookName("Book" + j);
		books.add(bookBO);
	    }

	    randomNumber = rn.nextInt(10) + 1;

	    SubjectBO subjectBO = null;
	    List<SubjectBO> subjects = new ArrayList<SubjectBO>();
	    for (int j = 1; j <= randomNumber; j++) {
		subjectBO = new SubjectBO();
		subjectBO.setSubjectName("SubJect" + j);
		subjectBO.setBooks(books);
		subjects.add(subjectBO);

	    }

	    randomNumber = rn.nextInt(6000) + 1;

	    employeeToSave.setUserName("user" + randomNumber);
	    employeeToSave.setEmployeeName("emp" + randomNumber);

	    randomNumber = rn.nextInt(20) + 1;
	    employeeToSave.setAge(randomNumber);
	    employeeToSave.setSubjects(subjects);
	    employees.add(employeeToSave);
	    employeeService.saveOrUpdateEmployee(employeeToSave);
	}
	//employeeService.saveEmployeesInBulk(employees);

    }

}
