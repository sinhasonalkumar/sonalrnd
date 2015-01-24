package com.sonal.randomtest.tryfinally;

public class TryFinallyMain {

	public static void main(String[] args) {
		try{
			System.out.println("In The try Block");
			System.out.println("In Case Of System.exit(1) Finally Block Will Not Be Called...");
			System.exit(1);
		}finally{
			System.out.println("In The Finally Block");
		}
	}
}
