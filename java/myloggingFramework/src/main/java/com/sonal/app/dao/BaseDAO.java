package com.sonal.app.dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class BaseDAO extends HibernateDaoSupport{

	@Autowired
	private void attachSessionFactoryToHibernateDaoSupport(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
}
