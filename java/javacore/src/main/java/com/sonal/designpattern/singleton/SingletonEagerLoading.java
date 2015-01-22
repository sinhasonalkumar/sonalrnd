package com.sonal.designpattern.singleton;

public class SingletonEagerLoading {

	private static SingletonEagerLoading singletonEagerLoadingInstance = initSingletonEagerLoadingInstance();
	
	private SingletonEagerLoading(){
		System.out.println("----------------------------------");
		System.out.println("SingletonEagerLoading Created !!");
		System.out.println("----------------------------------");
	}
	
	private static SingletonEagerLoading initSingletonEagerLoadingInstance(){
		return new SingletonEagerLoading();
	}
	
	public static SingletonEagerLoading getInstance(){
		return singletonEagerLoadingInstance;
	}
	
	public void show(){
		System.out.println(singletonEagerLoadingInstance + " HashCode :: " + singletonEagerLoadingInstance.hashCode());
	}
}
