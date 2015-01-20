package com.sonal.basic;

public class PalindromeMain {

	public static void main(String[] args) {
		String inputString = "121";
		checkPalindrome(inputString);
		
		inputString = "abc";
		checkPalindrome(inputString);
	}

	private static void checkPalindrome(String inputString) {
		int inputStringLength = inputString.length();
		StringBuilder reverseInputString = new StringBuilder(inputStringLength);

		for (int i = inputStringLength - 1; i >= 0; i--) {
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
}
