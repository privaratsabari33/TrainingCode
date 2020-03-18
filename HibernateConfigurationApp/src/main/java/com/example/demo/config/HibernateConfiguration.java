package com.example.demo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
public class HibernateConfiguration {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	@Primary
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("com.example.demo.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate-dialect","org-hibernate-dialect-H2Dialect");
		return hibernateProperties;
		
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
			
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean eBean=new LocalContainerEntityManagerFactoryBean();
		eBean.setDataSource(dataSource);
		eBean.setPackagesToScan("com.example.demo.model");
		JpaVendorAdapter hibernateAdapter=new  HibernateJpaVendorAdapter();
		eBean.setJpaVendorAdapter(hibernateAdapter);
		eBean.setJpaProperties(hibernateProperties());
		return eBean.getObject();
		
		
	}
}

