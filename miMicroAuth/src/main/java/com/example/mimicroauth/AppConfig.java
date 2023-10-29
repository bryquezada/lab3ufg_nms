package com.example.mimicroauth;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.mimicroauth.application.datasource.DSPruebas;

@Component
public class AppConfig {

	public AppConfig(ApplicationContext applicationContext) {
		DSPruebas dsPruebas = applicationContext.getBean(DSPruebas.class);
		if(dsPruebas != null) {
			System.out.println("INSTANCIA DSPRUEBAS CREADA");
		}
		
		
	}

}
