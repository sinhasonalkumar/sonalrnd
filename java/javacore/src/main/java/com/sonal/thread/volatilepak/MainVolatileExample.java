package com.sonal.thread.volatilepak;

import java.util.Scanner;

public class MainVolatileExample {

	public static void main(String[] args) {
		MyService myService = new MyService();
		
		Runnable volatileExampleRunnable1 = new VolatileExample(myService);
		Runnable volatileExampleRunnable2 = new VolatileExample(myService);
		Runnable volatileExampleRunnable3 = new VolatileExample(myService);
		
		Thread volatileExampleThread1 = new Thread(volatileExampleRunnable1);
		Thread volatileExampleThread2 = new Thread(volatileExampleRunnable2);
		Thread volatileExampleThread3 = new Thread(volatileExampleRunnable3);
		
		
		volatileExampleThread1.start();
		volatileExampleThread2.start();
		volatileExampleThread3.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		myService.returnKeyPressed();
		
		
	}
}
