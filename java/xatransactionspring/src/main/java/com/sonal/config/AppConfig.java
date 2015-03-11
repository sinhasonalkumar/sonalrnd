package com.sonal.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.hibernate.SessionFactory;
import org.hibernate.engine.transaction.internal.jta.JtaTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.icatch.jta.hibernate4.AtomikosPlatform;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mongodb.Mongo;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

@Configuration
@ComponentScan(basePackages = { "com.sonal" })
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public HibernateTemplate hibernateTemplate() {
	HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory());
	return hibernateTemplate;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikosTransactionManager() {
	UserTransactionManager userTransactionManager = new  UserTransactionManager();
	userTransactionManager.setForceShutdown(false);
	
	return userTransactionManager;
    }

    @Bean
    public UserTransaction atomikosUserTransaction() throws SystemException {
	UserTransactionImp userTransaction = new UserTransactionImp();
	userTransaction.setTransactionTimeout(300);
	
	return userTransaction;
    }
    
    
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws SystemException {
	JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
	
	jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
	jtaTransactionManager.setUserTransaction(atomikosUserTransaction());
	jtaTransactionManager.setAllowCustomIsolationLevels(true);
	
	return jtaTransactionManager;
    }

    @Bean
    public SessionFactory sessionFactory() {

	LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
	localSessionFactoryBuilder.addProperties(hibernateProperties());
	localSessionFactoryBuilder.scanPackages("com.sonal.persistence.bo");
	SessionFactory sessionFactory = localSessionFactoryBuilder.buildSessionFactory();

	return sessionFactory;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource getDataSource() {
	MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
	mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
	mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/mylocaldb");
	mysqlXaDataSource.setUser("root");
	mysqlXaDataSource.setPassword("");
	
	AtomikosDataSourceBean xaDtaSource = new AtomikosDataSourceBean();

	xaDtaSource.setUniqueResourceName("mysqlDataSource");
	xaDtaSource.setXaDataSource(mysqlXaDataSource);

	xaDtaSource.setPoolSize(15);
	xaDtaSource.setMaxPoolSize(30);
	xaDtaSource.setMinPoolSize(10);
	xaDtaSource.setBorrowConnectionTimeout(5000);
	xaDtaSource.setReapTimeout(6000);

	return xaDtaSource;
    }

    private Properties hibernateProperties() {
	Properties hibernateProperties = new Properties();
	hibernateProperties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
	hibernateProperties.put("hibernate.current_session_context_class", "jta");
	
	//hibernateProperties.put("hibernate.transaction.factory_class", JtaTransactionFactory.class.getName());
	//TODO :: // Since Hibernate4 took TransactionManager lookup and says JTA provider to implement. So need to figure out the way hibernate can pick Atomikos JTA transaction and Spring
	//hibernateProperties.put("hibernate.transaction.manager_lookup_class", PlatformTransactionManager.class.getName());
	hibernateProperties.put("hibernate.format_sql", "true");
	hibernateProperties.put("hibernate.show_sql", "true");
	hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	// hibernateProperties.put("hibernate.hbm2ddl.auto", "create");

	return hibernateProperties;
    }

    @Bean
    public MongoFactoryBean mongoFactoryBean() {
	MongoFactoryBean mongoFactoryBean = new MongoFactoryBean();
	mongoFactoryBean.setHost("127.0.0.1");
	mongoFactoryBean.setPort(27017);
	return mongoFactoryBean;
    }

    // @Bean
    // public MongoClient mongo() throws Exception {
    // MongoClient client = new MongoClient("127.0.0.1");
    // client.setWriteConcern(WriteConcern.SAFE);
    // return client;
    // }

    @Bean
    public MongoTemplate mongoTemplate() {
	Mongo mongo = null;
	try {
	    mongo = mongoFactoryBean().getObject();
	    // mongo = mongo();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	String databaseName = "testdb";
	MongoTemplate mongoTemplate = new MongoTemplate(mongo, databaseName);
	return mongoTemplate;
    }

}
