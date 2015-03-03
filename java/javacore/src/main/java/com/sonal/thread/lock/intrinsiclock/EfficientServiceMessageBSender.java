package com.sonal.thread.lock.intrinsiclock;

import com.sonal.thread.lock.intrinsiclock.service.EfficientService;

public class EfficientServiceMessageBSender implements Runnable {

    private EfficientService efficientService;

    public EfficientServiceMessageBSender(EfficientService efficientService) {
	super();
	this.efficientService = efficientService;
    }

    @Override
    public void run() {
	try {

	    for (int i = 0; i < 5; i++) {
		efficientService.sendMessageB();

	    }
	    
	    System.out.println("Message MessageB Sent Count :: "  + efficientService.getMessageBCount());

	} catch (InterruptedException e) {

	}

    }

}
