package com.sonal.thread.lock.intrinsiclock;

import com.sonal.thread.lock.intrinsiclock.service.InefficientService;

public class InefficientServiceMessageBSender implements Runnable {

    private InefficientService inefficientService;

    public InefficientServiceMessageBSender(InefficientService inefficientService) {
	super();
	this.inefficientService = inefficientService;
    }

    @Override
    public void run() {
	try {
	    for (int i = 0; i < 5; i++) {
		inefficientService.sendMessageB();

	    }

	    System.out.println("Message MessageB Sent Count :: " + inefficientService.getMessageBCount());
	} catch (InterruptedException e) {

	}

    }

}
