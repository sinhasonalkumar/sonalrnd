package com.sonal.thread.syncronized;

public class TestSyncronizedClassMain {

    public static void main(String[] args) throws InterruptedException {
	
	TestSyncronizedClass testObject1 = new TestSyncronizedClass();
	TestSyncronizedClass testObject2 = new TestSyncronizedClass();
	
	Runnable runnable1 = new Runnable() {
	    
	    @Override
	    public void run() {
		System.out.println("Current Thread :: " + Thread.currentThread().getName() + " Started ");
		
		//testObject1.addOne();
		TestSyncronizedClass.addOneStatic();
		
		System.out.println("Current Thread :: " + Thread.currentThread().getName() + " Ended ");
	    }
	};
	
	Runnable runnable2 = new Runnable() {
	    
	    @Override
	    public void run() {
		
		System.out.println("Current Thread :: " + Thread.currentThread().getName() + " Started ");
		
		testObject1.showX();
		testObject1.addOne();
		testObject1.addOneStatic();
		
		
		System.out.println("Current Thread :: " + Thread.currentThread().getName() + " Ended ");
		
		
	    }
	};
	
	Runnable runnable3 = new Runnable() {
	    
	    @Override
	    public void run() {
		
		System.out.println("Current Thread :: " + Thread.currentThread().getName() + " Started ");
		
		testObject2.showX();
		testObject2.addOne();
		testObject2.addOneStatic();
		
		System.out.println("Current Thread :: " + Thread.currentThread().getName() + " Ended ");
	    }
	};
	
	Thread thread1 = new Thread(runnable1,"Thread1");
	thread1.start();
	
	Thread.sleep(300);
	
	Thread thread2 = new Thread(runnable2,"Thread2");
	thread2.start();
	
	Thread thread3 = new Thread(runnable3,"Thread3");
	thread3.start();
	
	
	
    }
}
