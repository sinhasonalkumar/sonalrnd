package com.sonal.thread.lock.intrinsiclock;

import com.sonal.thread.lock.intrinsiclock.service.EfficientService;

public class EfficientServiceMessageASender implements Runnable {

    private EfficientService efficientService;

    public EfficientServiceMessageASender(EfficientService efficientService) {
	super();
	this.efficientService = efficientService;
    }

    @Override
    public void run() {
	try {
	    for (int i = 0; i < 5; i++) {
		efficientService.sendMessageA();

	    }
	    System.out.println("Message MessageA Sent Count :: " + efficientService.getMessageACount());
	} catch (InterruptedException e) {

	}

    }

}
