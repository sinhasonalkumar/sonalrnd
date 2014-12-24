package com.sonal.async;

import java.util.concurrent.Callable;

public class CallableExampleTask implements Callable<String> {

	private String imagePath;
	
	public void setImagePath(String imagePath){
		this.imagePath = imagePath;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("Async Process Started !! ");
		String message = null;
		Thread.sleep(3000l);
		message = imagePath + " :: Image Uploaded Successfully";
		System.out.println("Async Process Completed Successfully !!");
		return message;
	}

}
