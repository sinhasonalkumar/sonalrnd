package com.sonal;

import java.util.Calendar;

public class RandomTest {

	public static void main(String[] args) {
		Calendar currentDate = Calendar.getInstance();
		System.out.println(currentDate.getTime());
		currentDate.add(Calendar.MINUTE, -20 * 60);
		System.out.println(currentDate.getTime());
	}

}
