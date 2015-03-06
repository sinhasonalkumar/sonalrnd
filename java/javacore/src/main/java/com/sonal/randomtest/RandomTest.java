package com.sonal.randomtest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RandomTest {

	public static void main(String[] args) {
		Calendar currentDate = Calendar.getInstance();
		System.out.println(currentDate.getTime());
		currentDate.add(Calendar.MINUTE, -20 * 60);
		System.out.println(currentDate.getTime());
		
		char a = 'a';
		char b = 'b';
		char c = 'a';
		System.out.println(a == b);
		System.out.println(a == c);
		 
	}

}

class Student implements Comparable<Student>{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Student other = (Student) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
    
    @Override
    public int compareTo(Student studentToCompare){
	int compareTo = this.getId().compareTo(studentToCompare.getId());
	return compareTo;
    }
    
    @Override
    public String toString(){
	String objAsString = this.getId();
	return objAsString;
    }
    
    public static void main(String[] args) {
	Student student1  = new Student();
	student1.setId("4");
	
	Student student2  = new Student();
	student2.setId("1");
	
	Student student3  = new Student();
	student3.setId("2");
	
	Student student4  = new Student();
	student4.setId("3");
	
	List<Student> studentsList = new ArrayList<Student>();
	studentsList.add(student1);
	studentsList.add(student2);
	studentsList.add(student3);
	studentsList.add(student4);
	
	System.out.println(studentsList);
	
	//Collections.sort(studentsList);
	Collections.sort(studentsList, StudentComparator.getInstance());
	
	System.out.println(studentsList);
    }
    
    
    
    
}

class StudentComparator implements Comparator<Student>{
    
    @Override
    public int compare(Student s1 , Student s2){
	
	int compareTo = s1.getId().compareTo(s2.getId());
	
	return compareTo;
    }
    
    public static StudentComparator getInstance(){
	return new StudentComparator();
    }
}
