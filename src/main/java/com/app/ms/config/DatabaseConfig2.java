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
public class DatabaseConfig2 {

	@Primary
	@Bean(name="dataSource2")
	@ConfigurationProperties(prefix="spring.datasource2")
	public DataSource datasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary 
	@Bean(name="entityManagerFactory2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("dataSource2") DataSource dataSource) {

		return entityManagerFactoryBuilder
				.dataSource(dataSource)
				.packages("com.app.ms.db2.entities")// entity package
				.persistenceUnit("db2")
				.build();
	}
	
	
	@Primary
	@Bean(name="transactionManager2")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}
	
	
}
