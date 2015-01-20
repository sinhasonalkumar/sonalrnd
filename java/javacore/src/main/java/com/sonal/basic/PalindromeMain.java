package com.sonal.basic;

public class PalindromeMain {

	public static void main(String[] args) {
		String inputString = "121";
		checkPalindromeWay1(inputString);
		
		inputString = "abc";
		checkPalindromeWay1(inputString);
		
		inputString = "121";
		checkPalindromeWay2(inputString);
		
		inputString = "abc";
		checkPalindromeWay2(inputString);
	}

	private static void checkPalindromeWay1(String inputString) {
		int inputStringLength = inputString.length();
		StringBuilder reverseInputString = new StringBuilder(inputStringLength);

		for (int i = (inputStringLength - 1); i >= 0; i--) {
			reverseInputString.append(inputString.charAt(i));
		}
		
		System.out.println(inputString);
		System.out.println(reverseInputString);

		if (inputString.equals(reverseInputString.toString())) {
			System.out.println("Palindrome !!");
		} else {
			System.out.println("Not Palindrome !!");
		}
	}
	
	private static void checkPalindromeWay2(String inputString) {
		
		StringBuilder reverseInputString = new StringBuilder(inputString).reverse();
		
		System.out.println(inputString);
		System.out.println(reverseInputString);

		if (inputString.equals(reverseInputString.toString())) {
			System.out.println("Palindrome !!");
		} else {
			System.out.println("Not Palindrome !!");
		}
	}
}
