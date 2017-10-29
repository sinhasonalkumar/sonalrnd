package com.sonal.thread.syncronized;

public class TestSyncronizedClass {

    private int x;
    
    public TestSyncronizedClass() {
	x=0;
    }
    
    public synchronized void addOne() {
	 System.out.println("Current Thread :: " + Thread.currentThread().getName() +" --> addOne synchronized START...");
	//showX();
	try {
	    Thread.sleep(10000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	x++;
	System.out.println("Current Thread :: " + Thread.currentThread().getName() +" --> addOne synchronized END...");
    }
    
    public static synchronized void addOneStatic() {
	 System.out.println("Current Thread :: " + Thread.currentThread().getName() +" --> addOneStatic synchronized START...");
	//showX();
	try {
	    Thread.sleep(10000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println("Current Thread :: " + Thread.currentThread().getName() +" --> addOneStatic synchronized END...");
   }
    
  
    public void showX() {
	/*try {
	    System.out.println("showX SLEEPING...");
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}*/
	
	System.out.println("Current Thread :: " + Thread.currentThread().getName() +" --> Running ShowX Method :: " + x);
    }
}
