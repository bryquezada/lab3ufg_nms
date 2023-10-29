package com.example.mimicrotrm.application.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mimicrotrm.application.datasource.DSPruebas;
import com.example.mimicrotrm.domain.MonedaRespuesta;
import com.example.mimicrotrm.domain.TRM;

@Repository
public class TRMImplRepo implements ITRMREpo{
	
	@Autowired
	public DSPruebas dsPruebas;

	@Override
	public double buscar(String moneda, String intercambio) {
		List<TRM> trm;
		
		String query = "SELECT * FROM TRM WHERE moneda = '"  + moneda + "' ";
		query += "AND intercambio = '" + intercambio + "' ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dsPruebas.dataSource());
		trm = jdbcTemplate.query(query, new BeanPropertyRowMapper<TRM>(TRM.class));
		
		return trm.get(0).getValor();
	}

}
