package com.sonal.randomtest;

public class RandomTestOne {

    public static void main(String[] args) {
	Abc abc1 = new Abc("Sonal");
	Abc abc2 = new Abc("Sonal");

	System.out.println(abc1 == abc2);
	System.out.println(abc1.equals(abc2));
	
	//Xyz xyz1 = new Xyz("sonal");
	Xyz xyz1 = new Xyz(null);
	//Xyz xyz2 = new Xyz("sonal");
	Xyz xyz2 = new Xyz(null);
	
	System.out.println(xyz1 == xyz2);
	System.out.println(xyz1.equals(xyz2));
	
	String s1 = "Sonal";
	String s2 = "SONAL";
	
	System.out.println(s1 == s2);
	
    }

}

class Abc {

    private String name;

    public Abc(String name) {
	this.name = name;
    }
}

class Xyz {

    private String name;

    public Xyz(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public boolean equals(Object xyz) {
	boolean isEqual = false;
	if (xyz == null) {
	    isEqual = false;
	} else {
	    if (!getClass().getName().equals(xyz.getClass().getName())) {
		isEqual = false;
	    } else {
		if ( ((Xyz) xyz).getName() != null && ((Xyz) xyz).getName().equalsIgnoreCase(this.getName())) {
		    isEqual = true;
		} else {
		    if ( ((Xyz) xyz).getName() == null && this.getName() == null){
			 isEqual = true;
		    }else{
			isEqual = false;
		    }
		    
		}
	    }
	}
	return isEqual;
    }

    @Override
    public int hashCode() {
	int hashCode = 1;
	if(this.getName() != null){
	    hashCode = 31 + this.hashCode() + this.getName().hashCode();
	}else{
	    hashCode = 31 + this.hashCode();
	}

	return hashCode;
    }
}