package com.sonal.util.logtransactiopncontext;

import java.util.UUID;

public class LogTransactionContext {

	private static final InheritableThreadLocal<UUID> logTransactionContext = new InheritableThreadLocal<UUID>(); // context available to its child thread 
	//private static final ThreadLocal<UUID> logTransactionContext = new ThreadLocal<UUID>(); // context not available to its child thread
	
	public static void setTransactionId(UUID transactionID) {
		logTransactionContext.set(transactionID);
	}
	
	public static UUID getTransactionId() {
		return logTransactionContext.get();
	}
	
	public static void removeTransactionId() {
		logTransactionContext.remove();
	}
}
