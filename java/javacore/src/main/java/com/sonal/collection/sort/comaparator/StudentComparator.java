package com.sonal.collection.sort.comaparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentVO> {

	@Override
	public int compare(StudentVO student1, StudentVO student2) {
		int compareValue = 0;
		//compareValue = student1.getStuName().compareTo(student2.getStuName());
		if(student1.getAge() == student2.getAge()){
			compareValue = 0;
		}else{
			if(student1.getAge() > student2.getAge()){
				compareValue = 1;
			}else{
				compareValue = -1;
			}
		}
		return compareValue;
	}

	
}
