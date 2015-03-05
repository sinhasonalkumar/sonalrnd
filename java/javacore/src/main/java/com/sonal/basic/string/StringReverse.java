package com.sonal.basic.string;

public class StringReverse {

    public static void main(String[] args) {
	String givenString = "Sonal";
	System.out.println("Reverse String of :: " + givenString + " :: Is :: " + reverseStringMethod1(givenString));
	System.out.println("Reverse String of :: " + givenString + " :: Is :: " + reverseStringMethod2(givenString));
	System.out.println("Reverse String of :: " + givenString + " :: Is :: " + reverseStringMethod3(givenString));
    }

    public static String reverseStringMethod1(String givenString) {
	StringBuilder stringBuilder = new StringBuilder();
	char[] charArray = givenString.toCharArray();
	int givenStringlength = charArray.length;
	for (int i = (givenStringlength - 1); i >= 0; i--) {
	    stringBuilder.append(charArray[i]);
	}
	return stringBuilder.toString();
    }

    public static String reverseStringMethod2(String givenString) {
	StringBuilder stringBuilder = new StringBuilder();

	int givenStringlength = givenString.length();
	for (int i = (givenStringlength - 1); i >= 0; i--) {
	    stringBuilder.append(givenString.charAt(i));
	}
	return stringBuilder.toString();
    }
    
    
    public static String reverseStringMethod3(String givenString) {
	StringBuilder stringBuilder = new StringBuilder(givenString);
	return stringBuilder.reverse().toString();
    }

}
