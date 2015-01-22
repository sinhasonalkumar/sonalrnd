package com.sonal.thread.volatilepak;

public class VolatileExample implements Runnable {

	private MyService myService;

	public VolatileExample(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.watchForReturnkey();
	}

}
