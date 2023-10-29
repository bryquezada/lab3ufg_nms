package com.example.mimicroauth.application.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mimicroauth.application.datasource.DSPruebas;
import com.example.mimicroauth.domain.UsuarioTrm;

@Repository
public class AutenticacionImplRepo implements IAutenticacionRepo{
	
	@Autowired
	public DSPruebas dsPruebas;

	@Override
	public UsuarioTrm buscar(String usuario, String contrasenya) {
		List<UsuarioTrm> usuarioTrm;
		
		String query = "SELECT idUsuario, usuario, contrasenya FROM usuariostrm WHERE usuario = :usuario ";
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dsPruebas.dataSource());
		
		Map<String, String> sqlparams = new HashMap<>();
		sqlparams.put("usuario", usuario);
		
		usuarioTrm = jdbcTemplate.query(query, sqlparams, new BeanPropertyRowMapper<UsuarioTrm>(UsuarioTrm.class));
		
		return usuarioTrm.get(0);
	}

	@Override
	public String registrar(String usuario, String contrasenya) {
		String id="";
		
		String query = "IF NOT EXISTS(SELECT * FROM usuariostrm WHERE usuario = :usuario) ";
		query += "BEGIN ";
		query += "INSERT INTO usuariostrm(usuario, contrasenya) ";
		query += "VALUES(:usuario, :contrasenya) ";
		query += "SELECT SCOPE_IDENTITY() ";
		query += "END ";
		query += "ELSE BEGIN ";
		query += "SELECT 'YA ESTA REGISTRADO' ";
		query += "END ";
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dsPruebas.dataSource());
		
		Map<String, String> sqlparams = new HashMap<>();
		sqlparams.put("usuario", usuario);
		sqlparams.put("contrasenya", contrasenya);
		
		id = jdbcTemplate.queryForObject(query, sqlparams, String.class);
		
		return id;
	}

}
