package com.sonal.thread.lock.intrinsiclock;

import java.util.Calendar;

import com.sonal.thread.lock.intrinsiclock.service.EfficientService;
import com.sonal.thread.lock.intrinsiclock.service.InefficientService;

public class ServicePerformnaceTestMain {

    public static void main(String[] args) throws InterruptedException {

	InefficientService inefficientService = new InefficientService();
	EfficientService efficientService = new EfficientService();

	inefficientServiceTest(inefficientService);
	
	System.out.println("--------- Now Watch ----------");
	Thread.sleep(3000);
	
	efficientServiceTest(efficientService);

    }

    private static void inefficientServiceTest(InefficientService inefficientService) {

	System.out.println("InefficientService Started ");
	long start = Calendar.getInstance().getTimeInMillis();

	Thread t1 = new Thread(new InefficientServiceMessageASender(inefficientService));
	Thread t2 = new Thread(new InefficientServiceMessageBSender(inefficientService));
	t1.start();
	t2.start();
	
	
	try {
	    t1.join();
	    t2.join();
	} catch (InterruptedException e) {
	  
	    e.printStackTrace();
	}

	long end = Calendar.getInstance().getTimeInMillis();
	System.out.println("InefficientService Completed ");

	System.out.println("Time Taken By InefficientService :: " + (end - start));
    }

    private static void efficientServiceTest(EfficientService efficientService) {
	System.out.println("EfficientService Started ");
	long start = Calendar.getInstance().getTimeInMillis();
	Thread t1 = new Thread(new EfficientServiceMessageASender(efficientService));
	Thread t2 = new Thread(new EfficientServiceMessageBSender(efficientService));
	t1.start();
	t2.start();
	
	try {
	    t1.join();
	    t2.join();
	} catch (InterruptedException e) {
	  
	    e.printStackTrace();
	}
	
	long end = Calendar.getInstance().getTimeInMillis();
	System.out.println("EfficientService Completed ");
	System.out.println("Time Taken By EfficientService :: " + (end - start));
    }

}
