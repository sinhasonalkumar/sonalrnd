package com.sonal.designpattern.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {

			SingletonLazyLoading.getIntsance().show();

			SingletonLazyLoadingDoubleLock.getInstance().show();

			SingletonEagerLoading.getInstance().show();
			
			SingletonEnum.INSTANCE.doSomeTask();
			
			System.out.println("-----------------Next---------------");

		}

	}
}
