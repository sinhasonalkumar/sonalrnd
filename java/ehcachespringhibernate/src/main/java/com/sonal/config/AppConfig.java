package com.sonal.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.sonal"})
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory());
		return hibernateTemplate;
	}
	

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory());
		return hibernateTransactionManager;
	}

	@Bean
	public SessionFactory sessionFactory() {
		
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		//LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getRoutingDataSource());
		
		localSessionFactoryBuilder.addProperties(hibernateProperties());
		localSessionFactoryBuilder.scanPackages("com.sonal.persistence.bo");
		SessionFactory sessionFactory = localSessionFactoryBuilder.buildSessionFactory();							
												
		return sessionFactory;
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mylocaldb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setMinIdle(10);
		dataSource.setMaxActive(100);
		dataSource.setInitialSize(10);
		dataSource.setMaxWait(10000);
		

		return dataSource;
	}
	
	/*@Bean
	public RoutingDataSource getRoutingDataSource(){
		RoutingDataSource dataSource = new RoutingDataSource();
		
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put(OperationType.READ, DataSourceHolder.getReadDataSource());
		targetDataSources.put(OperationType.WRITE, DataSourceHolder.getWriteDataSource());
		targetDataSources.put(OperationType.DEFAULT, DataSourceHolder.getWriteDataSource());
		
		dataSource.setTargetDataSources(targetDataSources);
		
		dataSource.setDefaultTargetDataSource(DataSourceHolder.getReadDataSource());
		
		return dataSource;
	}*/
	
	private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.format_sql", "true");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        //ibernateProperties.put("hibernate.hbm2ddl.auto", "create");
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
      
        hibernateProperties.put("hibernate.cache.use_second_level_cache", "true");
        hibernateProperties.put("hibernate.cache.use_query_cache", "true");
       // hibernateProperties.put("hibernate.cache.region.factory_class", "net.sf.ehcache.hibernate.EhCacheRegionFactory"); // Hibernate 3.x
        hibernateProperties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory"); // For Hibernate 4.x
        
        return hibernateProperties;
    }

}
