package com.sonal.thread.sleep;

import java.util.UUID;
import java.util.concurrent.ExecutorService;

public class TokenRenewMain {

    public static void main(String[] args) throws InterruptedException {
	String userName = "sonal";
	Token token = new Token();
	token.setAccessToken(UUID.randomUUID().toString());
	token.setRefreshToken(UUID.randomUUID().toString());
	TokenContext.addOrUpdateToken(userName, token);
	
	System.out.println("------------------------------------------------------------------");
	System.out.println("Init Token");
	System.out.println("Access Token :: " + token.getAccessToken());
	System.out.println("Refresh Token :: " + token.getRefreshToken());
	
	System.out.println("------------------------------------------------------------------");
	
	Thread accessTokenUpdateServiceThread = new Thread(new AccessTokenUpdateService());
	Thread refreshNAccessTokenUpdateServiceThread = new Thread(new RefreshNAccessTokenUpdateService());
	
	ExecutorService executorService = TokenThreadPool.getInstance().getExecutorService();
	
	executorService.submit(accessTokenUpdateServiceThread);
	executorService.submit(refreshNAccessTokenUpdateServiceThread);
	
	executorService.shutdown();
	
    }
}
