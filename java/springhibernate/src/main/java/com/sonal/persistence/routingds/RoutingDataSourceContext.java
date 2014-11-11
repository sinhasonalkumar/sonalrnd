package com.sonal.persistence.routingds;

import com.sonal.persistence.routingds.enums.OperationType;

public class RoutingDataSourceContext {

	private static final InheritableThreadLocal<OperationType> contextHolder = new InheritableThreadLocal<OperationType>();

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
