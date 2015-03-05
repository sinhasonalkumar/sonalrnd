package com.sonal.basic.string;

public class PrimeNumberUtility {

    public static void main(String[] args) {
	System.out.println(primeOrNot(3));
	System.out.println(primeOrNot(2));
	System.out.println(primeOrNot(0));
	System.out.println(primeOrNot(97));
	System.out.println(primeOrNot(99));
	System.out.println("-----------------------------------");

	System.out.println(primeOrNotBrutal(3));
	System.out.println(primeOrNotBrutal(2));
	System.out.println(primeOrNotBrutal(0));
	System.out.println(primeOrNotBrutal(97));
	System.out.println(primeOrNotBrutal(99));
    }

    public static boolean primeOrNotBrutal(int number) {
	boolean isPrime = true;
	if (number == 0) {
	    isPrime = false;
	}
	for (int i = 2; i < number; i++) {
	    if (number % i == 0) {
		isPrime = false;
		break;
	    }
	}
	return isPrime;
    }

    public static boolean primeOrNot(int number) {
	boolean isPrime = false;
	int count = 0;
	for (int i = 2; i <= (number / 2); i++) {
	    if (number % i == 0) {
		count++;
		break;
	    }
	}
	if (count == 0 && number != 1 && number != 0) {
	    isPrime = true;
	}
	return isPrime;
    }
}
