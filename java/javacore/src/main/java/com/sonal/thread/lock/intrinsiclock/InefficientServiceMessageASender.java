package com.sonal.thread.lock.intrinsiclock;

import com.sonal.thread.lock.intrinsiclock.service.InefficientService;

public class InefficientServiceMessageASender implements Runnable{

    private InefficientService inefficientService;

    public InefficientServiceMessageASender(InefficientService inefficientService) {
	super();
	this.inefficientService = inefficientService;
    }

    @Override
    public void run() {
	try {
	    for(int i= 0 ; i< 5 ; i ++){
		inefficientService.sendMessageA();
	    }
	    System.out.println("Message MessageA Sent Count :: " + inefficientService.getMessageACount());
	} catch (InterruptedException e) {
	   
	}
	
    }
    
    
}
