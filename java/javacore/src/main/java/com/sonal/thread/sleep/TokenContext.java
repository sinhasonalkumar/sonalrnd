package com.sonal.thread.sleep;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenContext {

    private static Map<String, Token> tokenMap = new ConcurrentHashMap<String, Token>();

    public static Token getToken(String userName) {
	Token token = tokenMap.get(userName);
	return token;
    }

    public static void addOrUpdateToken(String userName, Token token) {
	tokenMap.put(userName, token);
    }

}
