package com.sonal.collection.sort.comparable;

public class EmployeeVO  implements Comparable<EmployeeVO>{

	private int age;
	
	private String empName;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public int compareTo(EmployeeVO empVo) {
		
		//compareToValue = this.empName.compareTo(empVo.getEmpName());
		
		// Ascending order of age.
		
		int compareToValue = 0;
		if(this.age == empVo.getAge()){
			compareToValue = 0;
		}else{
			if(this.age > empVo.getAge()){
				compareToValue = 1;
			}else{
				compareToValue = -1;
			}
		}
		return compareToValue;
	}

	@Override
	public String toString() {
		String object = "{ Age : " + this.age + " :: Employee Name : " + this.empName + " }";
		
		return object;
	}
	
	
	
	
}
