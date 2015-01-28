package com.sonal.collection.sort.comaparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComaparatorMain {

	public static void main(String[] args) {
		
		StudentVO StudentVO1 = new StudentVO();
		StudentVO1.setAge(29);
		StudentVO1.setStuName("ABC");
		
		
		StudentVO StudentVO2 = new StudentVO();
		StudentVO2.setAge(30);
		StudentVO2.setStuName("UVW");
		
		
		
		StudentVO StudentVO3 = new StudentVO();
		StudentVO3.setAge(28);
		StudentVO3.setStuName("XYZ");
		
		StudentVO StudentVO4 = new StudentVO();
		StudentVO4.setAge(30);
		StudentVO4.setStuName("EFG");
		
		List<StudentVO> students = new ArrayList<StudentVO>();
		students.add(StudentVO1);
		students.add(StudentVO2);
		students.add(StudentVO3);
		students.add(StudentVO4);
		
		System.out.println("Before Sorting");
		
		System.out.println(students);
		
		Collections.sort(students, new StudentComparator());
		
		System.out.println("After Sorting");
		
		System.out.println(students);
	}
}
