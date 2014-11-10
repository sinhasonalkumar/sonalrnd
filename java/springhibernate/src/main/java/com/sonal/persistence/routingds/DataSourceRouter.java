package com.sonal.persistence.routingds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSourceRouter extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return RoutingDataSourceContext.getOperationType();
	}

}
