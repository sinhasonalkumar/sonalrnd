package com.sonal.designpattern.singleton;

public class SingletonLazyLoadingDoubleLock {

	private static volatile SingletonLazyLoadingDoubleLock singletonLazyLoadingDoubleLockInstance;

	private SingletonLazyLoadingDoubleLock() {
		System.out.println("SingletonLazyLoadingDoubleLock Created !!");
	}

	public static SingletonLazyLoadingDoubleLock getInstance() {
		if (singletonLazyLoadingDoubleLockInstance == null) {
			synchronized (SingletonLazyLoadingDoubleLock.class) {
				if (singletonLazyLoadingDoubleLockInstance == null) {
					singletonLazyLoadingDoubleLockInstance = new SingletonLazyLoadingDoubleLock();
				}
			}

		}

		return singletonLazyLoadingDoubleLockInstance;
	}
	
	public void show(){
		System.out.println(singletonLazyLoadingDoubleLockInstance + " HashCode :: " + singletonLazyLoadingDoubleLockInstance.hashCode());
	}
}
