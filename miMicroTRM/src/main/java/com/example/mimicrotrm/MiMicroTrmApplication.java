package com.example.mimicrotrm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MiMicroTrmApplication {
	
	
	public static void main(String[] args) {

		SpringApplication.run(MiMicroTrmApplication.class, args);
	}
	

}
