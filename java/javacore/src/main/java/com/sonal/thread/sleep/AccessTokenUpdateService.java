package com.sonal.thread.sleep;

import java.util.UUID;

public class AccessTokenUpdateService implements Runnable {

    @Override
    public void run() {
	for (int i = 0; i < 2; i++) {
	    try {
		Thread.sleep(2000l);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    String userName = "sonal";
	    Token token = TokenContext.getToken(userName);
	    System.out.println("------------------------------------------------------------------");
	    System.out.println("Before AccessTokenUpdateService ");
	    System.out.println("Access Token :: " + token.getAccessToken());
	    System.out.println("Refresh Token :: " + token.getRefreshToken());

	    token.setAccessToken(UUID.randomUUID().toString());

	    TokenContext.addOrUpdateToken(userName, token);

	    System.out.println("After AccessTokenUpdateService ");
	    System.out.println("Access Token :: " + token.getAccessToken());
	    System.out.println("Refresh Token :: " + token.getRefreshToken());

	    System.out.println("------------------------------------------------------------------");
	}

    }

}
