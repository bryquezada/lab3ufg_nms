package com.example.mimicroauth.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mimicroauth.application.repository.IAutenticacionRepo;
import com.example.mimicroauth.domain.UsuarioTrm;

@Service
public class AutenticacionImplService implements IAutenticacionService{
	
	@Autowired
	private IAutenticacionRepo repo;

	@Override
	public UsuarioTrm buscar(String usuario, String contrasenya) {
		return repo.buscar(usuario, contrasenya);
	}

	@Override
	public String registrar(String usuario, String contrasenya) {
		return repo.registrar(usuario, contrasenya);
	}

}