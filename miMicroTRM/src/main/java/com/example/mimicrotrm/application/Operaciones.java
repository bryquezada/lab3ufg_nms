package com.example.mimicrotrm.application;

import java.awt.print.Printable;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

import com.example.mimicrotrm.application.service.ITRMService;
import com.example.mimicrotrm.domain.Moneda;
import com.example.mimicrotrm.domain.MonedaRespuesta;
import com.example.mimicrotrm.domain.TRM;

@Controller
public class Operaciones {

//	@Autowired
//	public JdbcTemplate jdbcTemplate;

	@Autowired
	public ITRMService trmService;

	public MonedaRespuesta getConversion(Moneda moneda) {
		MonedaRespuesta resp = new MonedaRespuesta();
		double trm;

		try {
			trm = trmService.buscar(moneda.getMoneda(), moneda.getIntercambio());

			resp.setCantidad(moneda.getValor());
			resp.setResultado(moneda.getValor() * trm);
			resp.setSuccessfull(true);
			resp.setRespuesta("conversión finalizada");
		} catch (Exception ex) {
			resp.setSuccessfull(false);
			resp.setRespuesta("Error Exception: " + String.valueOf(ex));
		}

		return resp;
	}
}
