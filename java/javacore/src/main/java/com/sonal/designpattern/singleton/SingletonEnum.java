package com.sonal.designpattern.singleton;

// Only problem with snum singleton is that we have to make sure this enum is loaded by  only one class loader. Otherwise if this enum is loaded by multiple classloader then we will have mutiple instance of this enum which will not be singleton in that case.
public enum SingletonEnum {

	INSTANCE;

	private SingletonEnum() {
		System.out.println("----------------------------------");
		System.out.println("Creating Instance Of SingletonEnum !!");
		System.out.println("----------------------------------");
	}

	public void doSomeTask() {
		System.out.println("Doing Some Task");
	}
}
