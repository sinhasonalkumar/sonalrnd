package com.sonal.basic.string;

public class ArmStringNumberUtility {

    public static void main(String[] args) {
	//printDigits(153);
	isArmStrongNumber(153);
	isArmStrongNumber(309);
	isArmStrongNumber(0);
    }
    
    public static boolean isArmStrongNumber(int number){
	
	boolean isArmStrong  = false;
	int givenNumber = number;
	int computedNumber = 0;
	int remainder = 0;
	while(number != 0){
	    remainder = number % 10;
	    number = number / 10;
	    computedNumber += remainder * remainder * remainder;
	}
	 if(computedNumber == givenNumber){
	     System.out.println("True");
	     isArmStrong = true;
	 }else{
	     System.out.println("False");
	 }
	return isArmStrong;
    }
    
    public static void printDigits(int number){
	while(number != 0){
	    System.out.println(number % 10);
	    number = number/10;
	    
	}
    }
}

