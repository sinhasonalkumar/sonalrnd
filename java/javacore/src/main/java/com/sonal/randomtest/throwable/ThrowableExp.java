package com.sonal.randomtest.throwable;

import java.io.IOException;

public class ThrowableExp {

	public static void main(String[] args) {
		try {
			doSomethingOuter();
		} catch (Throwable e) {
			if(e instanceof IOException){
				System.err.println("IO Exception Identified");
			}else{
				e.printStackTrace();
			}
		}
	}
	
	public static void doSomething() throws Throwable{
		throw new IOException();
	}
	
	
	public static void doSomethingOuter() throws Throwable{
		doSomething();
	}
}
