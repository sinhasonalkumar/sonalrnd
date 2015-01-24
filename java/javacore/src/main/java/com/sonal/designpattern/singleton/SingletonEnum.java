package com.sonal.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;

// Only problem with snum singleton is that we have to make sure this enum is loaded by  only one class loader. Otherwise if this enum is loaded by multiple classloader then we will have mutiple instance of this enum which will not be singleton in that case.
/*
 * Advantages of Enum Singleton
 * 	1) ThreadSafe
 * 	2) Enum Singletons handled Serialization by themselves.No more need to implement readResolve()
 * 	
 * Disadvantages Of Enum Singleton 
 * 	1) Only available in Java 5 or above
 * 	2) Enum Singleton cannot extend any other class (you can only implement interfaces)
 *  3) If you have more than One Member in Enum then constructor will called more than one time which will kill the point of having Singletion
 *  4) Problem with snum singleton is that we have to make sure this enum is loaded by  only one class loader. Otherwise if this enum is loaded by multiple classloader then we will have mutiple instance of this enum which will not be singleton in that case.
 *  
 */

public enum SingletonEnum {

	//INSTANCE,INSTANCE2; // This will call constructor twice and this SingletionEnum will not be Singletion anymore. 
	INSTANCE;
	
	private Map<String, String> config;

	private SingletonEnum() {
		System.out.println("----------------------------------");
		System.out.println("Creating Instance Of SingletonEnum !!");
		System.out.println("Loading Config");
		config = new HashMap<String, String>();
		config.put("SomeKey", "SomeValue");
		System.out.println("Config Loaded");
		System.out.println("----------------------------------");
		
	}

	public void doSomeTask() {
		System.out.println("Doing Some Task");
		System.out.println("Enum Singelton Config :: " + config);
	}
}
