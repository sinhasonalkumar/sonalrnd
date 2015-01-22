package com.sonal.designpattern.singleton;

public class SingletonLazyLoading {

	private static SingletonLazyLoading singletonLazyLoadingInstance;

	private SingletonLazyLoading() {
		System.out.println("----------------------------------");
		System.out.println("SingletonLazyLoading Created !!");
		System.out.println("----------------------------------");
	}

	public static synchronized SingletonLazyLoading getIntsance() {
		if (singletonLazyLoadingInstance == null) {
			singletonLazyLoadingInstance = new SingletonLazyLoading();
		}
		return singletonLazyLoadingInstance;
	}
	
	public void show(){
		System.out.println(singletonLazyLoadingInstance + " HashCode :: " + singletonLazyLoadingInstance.hashCode());
	}
}
