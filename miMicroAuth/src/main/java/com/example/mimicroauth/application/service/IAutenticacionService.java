package com.example.mimicroauth.application.service;

import com.example.mimicroauth.domain.UsuarioTrm;

public interface IAutenticacionService {
	UsuarioTrm buscar(String usuario, String contrasenya);
	String registrar(String usuario, String contrasenya);
}
