package com.sonal.thread.lock.intrinsiclock.service;

public class EfficientService {

    private int messageACount;

    private int messageBCount;
    
    private Object messageALock = new Object();
    private Object messageBLock = new Object();

    public void sendMessageA() throws InterruptedException {
	System.out.println("Sending MessageA");
	Thread.sleep(3000);
	System.out.println("MessageA Sent");
	synchronized (messageALock) {
	    messageACount++;
	}
	
    }

    public void sendMessageB() throws InterruptedException {
	System.out.println("Sending MessageB");
	Thread.sleep(3000);
	System.out.println("MessageB Sent");
	synchronized (messageBLock) {
	    messageBCount++;
	}
    }
    
    public int getMessageACount(){
	return messageACount;
    }
    
    public int getMessageBCount(){
   	return messageBCount;
       }

}
