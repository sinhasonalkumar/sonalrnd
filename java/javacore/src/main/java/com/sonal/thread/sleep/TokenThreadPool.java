package com.sonal.thread.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenThreadPool {

    private static TokenThreadPool tokenThreadPool = new TokenThreadPool();
    private ExecutorService executorService;

    private TokenThreadPool() {
	executorService = Executors.newCachedThreadPool();
    }
    
    public static TokenThreadPool  getInstance(){
	return tokenThreadPool;
    }
    
    public ExecutorService getExecutorService(){
	return executorService;
    }
}
