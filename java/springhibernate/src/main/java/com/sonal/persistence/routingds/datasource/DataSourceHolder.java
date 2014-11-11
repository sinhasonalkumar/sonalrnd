package com.sonal.persistence.routingds.datasource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DataSourceHolder {

	public static BasicDataSource getDataSource(String url) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setMinIdle(10);
		dataSource.setMaxActive(100);
		dataSource.setInitialSize(10);
		dataSource.setMaxWait(10000);
		return dataSource;
	}
	
	public static BasicDataSource getReadDataSource() {
		return DataSourceHolder.getDataSource("jdbc:mysql://localhost:3306/mylocalreaddb");
	}
	
	public static BasicDataSource getWriteDataSource() {
		return DataSourceHolder.getDataSource("jdbc:mysql://localhost:3306/mylocalwritedb");
	}
}
