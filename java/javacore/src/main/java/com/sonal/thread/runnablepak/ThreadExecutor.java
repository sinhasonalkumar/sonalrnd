package com.sonal.thread.runnablepak;


public class ThreadExecutor {

	public static void main(String[] args) {
		ThreadByThreadClass threadByThreadClass = new ThreadByThreadClass();
		threadByThreadClass.start();
		Runnable runnable = new ThreadByRunnbale();
		Thread threadByRunnbale = new Thread(runnable, "ThreadByRunnable");
		threadByRunnbale.start();
	}
}
