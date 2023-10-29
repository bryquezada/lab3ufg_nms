package com.example.mimicroauth.infraestructure.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mimicroauth.application.Operaciones;
import com.example.mimicroauth.domain.OperacionRepuesta;
import com.example.mimicroauth.domain.TokenRespuesta;
import com.example.mimicroauth.domain.Usuario;

@RestController
public class MicroController {
private static final Logger log = LoggerFactory.getLogger(MicroController.class);
	
	@Autowired
	Operaciones operaciones;
	
	@PostMapping("/iniciarSesion")
	public TokenRespuesta getAutenticacion(@RequestBody Usuario usuario) {
		log.info("usuario: " + usuario.getUsuario());
		System.out.println("usuario: " + usuario.getUsuario());
		return operaciones.iniciarSesion(usuario);
	}
	
	@PostMapping("/registrar")
	public OperacionRepuesta registrarUsuario(@RequestBody Usuario usuario) {
		log.info("usuario: " + usuario.getUsuario());
		System.out.println("usuario: " + usuario.getUsuario());
		return operaciones.registrarUsuario(usuario);
	}
}
