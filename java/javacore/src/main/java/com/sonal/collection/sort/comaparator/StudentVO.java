package com.sonal.collection.sort.comaparator;



public class StudentVO {

	private int age;
	
	private String stuName;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Override
	public String toString() {
		String object = "{ Age : " + this.age + " :: Employee Name : " + this.stuName + " }";
		
		return object;
	}
	
	
	
	
}
