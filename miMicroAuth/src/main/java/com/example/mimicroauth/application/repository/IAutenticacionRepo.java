package com.example.mimicroauth.application.repository;

import com.example.mimicroauth.domain.UsuarioTrm;

public interface IAutenticacionRepo {
	UsuarioTrm buscar(String usuario, String contrasenya);
	String registrar(String usuario, String contrasenya);
}
