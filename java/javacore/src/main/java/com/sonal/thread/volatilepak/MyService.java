package com.sonal.thread.volatilepak;

public class MyService {

	private volatile boolean hasReturnKeyPressed;

	public void watchForReturnkey() {
		while (!hasReturnKeyPressed) {
			System.out.println("Return key Not Pressed Yet !! ");
		}
		System.out.println("Return key Pressed !! ");
	}

	public void hitReturnKeyPressed() {
		hasReturnKeyPressed = true;
	}

	public boolean isHasReturnKeyPressed() {
		return hasReturnKeyPressed;
	}
	
}
