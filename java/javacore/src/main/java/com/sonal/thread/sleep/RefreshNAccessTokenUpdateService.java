package com.sonal.thread.sleep;

import java.util.UUID;

public class RefreshNAccessTokenUpdateService implements Runnable {

    @Override
    public void run() {
	
	try {
	    Thread.sleep(3000l);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	String userName = "sonal";
	Token token = TokenContext.getToken(userName);
	System.out.println("------------------------------------------------------------------");
	System.out.println("Before RefreshNAccessTokenUpdateService ");
	System.out.println("Access Token :: " + token.getAccessToken());
	System.out.println("Refresh Token :: " + token.getRefreshToken());
	token.setAccessToken(UUID.randomUUID().toString());
	token.setRefreshToken(UUID.randomUUID().toString());
	
	TokenContext.addOrUpdateToken(userName, token);
	
	System.out.println("After RefreshNAccessTokenUpdateService ");
	System.out.println("Access Token :: " + token.getAccessToken());
	System.out.println("Refresh Token :: " + token.getRefreshToken());
	
	System.out.println("------------------------------------------------------------------");
	
    }

}
