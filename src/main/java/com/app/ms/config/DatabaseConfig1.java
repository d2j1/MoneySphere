package com.app.ms.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig1 {

	@Primary
	@Bean(name="dataSource1")
	@ConfigurationProperties(prefix="spring.datasource1")
	public DataSource datasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary 
	@Bean(name="entityManagerFactory1")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("dataSource1") DataSource dataSource) {

		return entityManagerFactoryBuilder
				.dataSource(dataSource)
				.packages("com.app.ms.db1.entities")// entity package
				.persistenceUnit("db1")
				.build();
	}
	
	
	@Primary
	@Bean(name="transactionManager1")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}
	
	
}
