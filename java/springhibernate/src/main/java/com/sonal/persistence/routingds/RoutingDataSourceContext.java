package com.sonal.persistence.routingds;

import com.sonal.persistence.routingds.enums.OperationType;

public class RoutingDataSourceContext {

	private static final ThreadLocal<OperationType> contextHolder = new ThreadLocal<OperationType>();

	public static void setOperationType(OperationType operationType) {
		contextHolder.set(operationType);
	}

	public static OperationType getOperationType() {
		return (OperationType) contextHolder.get();
	}

	public static void clearOperationType() {
		contextHolder.remove();
	}
}
