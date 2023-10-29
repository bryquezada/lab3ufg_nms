package com.example.mimicroauth.application.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

@Service
public class DSPruebas{
	
	@Value("${spring.datasource.url}")
	String url1;
	
	@Value("${spring.datasource.username}")
	String username1;
	
	@Value("${spring.datasource.password}")
	String password1;
	
	public DataSource dataSource(){
		return new SimpleDriverDataSource(
				new com.microsoft.sqlserver.jdbc.SQLServerDriver(),
				url1,
				username1,
				password1
				);
	}
	

}
