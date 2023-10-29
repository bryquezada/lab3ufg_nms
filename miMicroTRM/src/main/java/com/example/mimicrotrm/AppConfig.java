package com.example.mimicrotrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.mimicrotrm.application.datasource.DSPruebas;
import com.example.mimicrotrm.application.service.ITRMService;
import com.example.mimicrotrm.domain.MonedaRespuesta;

@Component
public class AppConfig {
	
//	@Autowired
//	private ITRMService trmService;
//	
	public AppConfig(ApplicationContext applicationContext) {
		DSPruebas dsPruebas = applicationContext.getBean(DSPruebas.class);
		if(dsPruebas != null) {
			System.out.println("INSTANCIA DSPRUEBAS CREADA");
		}
		
//		ITRMService trmService = applicationContext.getBean(ITRMService.class);
//		if(trmService != null) {
//			MonedaRespuesta resp = new MonedaRespuesta();
//			double trm;
//			
//			trm = trmService.buscar("colon_sv", "dolar");
//			
//			resp.setCantidad(3);
//			resp.setResultado(3 * trm);
//			
//			System.out.println(String.valueOf(resp.getResultado()));
//		}
		
		
	}

}
