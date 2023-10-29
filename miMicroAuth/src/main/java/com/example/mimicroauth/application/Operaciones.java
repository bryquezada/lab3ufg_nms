package com.example.mimicroauth.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.mimicroauth.application.service.IAutenticacionService;
import com.example.mimicroauth.application.utils.JWTUtil;
import com.example.mimicroauth.domain.OperacionRepuesta;
import com.example.mimicroauth.domain.TokenRespuesta;
import com.example.mimicroauth.domain.Usuario;
import com.example.mimicroauth.domain.UsuarioTrm;
import com.example.mimicroauth.infraestructure.api.MicroController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Controller
public class Operaciones {

//	@Autowired
//	public JdbcTemplate jdbcTemplate;

	@Autowired
	public IAutenticacionService autenticacionService;
	
	@Autowired
	public JWTUtil jwtUtil;
	
	private static final Logger log = LoggerFactory.getLogger(MicroController.class);

	public TokenRespuesta iniciarSesion(Usuario usuario) {
		TokenRespuesta resp = new TokenRespuesta();
		UsuarioTrm usuarioTRM = new UsuarioTrm();
		boolean login;
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

		try {
			usuarioTRM = autenticacionService.buscar(usuario.getUsuario(), usuario.getContrasenya());

			if (!usuarioTRM.getContrasenya().isEmpty()) {
				login = argon2.verify(usuarioTRM.getContrasenya(), usuario.getContrasenya());
				log.info("argon_verify: " + String.valueOf(login));
				if (login) {
					resp.setUsuario(usuarioTRM.getUsuario());
					resp.setIdUsuario(String.valueOf(usuarioTRM.getIdUsuario()));
					resp.setRespuesta("usuario autenticado");
					resp.setSuccessfull(true);
					
					String jwt =  jwtUtil.create(String.valueOf(usuarioTRM.getIdUsuario()), usuarioTRM.getUsuario());
					resp.setToken(jwt);
					log.info("jwt_gen: " + String.valueOf(jwt));
				} else {
					resp.setSuccessfull(false);
					resp.setRespuesta("Usuario y/o contraseña incorrecta");
				}
			} else {
				resp.setSuccessfull(false);
				resp.setRespuesta("Usuario no encontrado");
			}

		} catch (Exception ex) {
			resp.setSuccessfull(false);
			resp.setRespuesta("Error Exception: " + String.valueOf(ex));
			log.info("error_exception: " + String.valueOf(ex));
		}

		return resp;
	}

	public OperacionRepuesta registrarUsuario(Usuario usuario) {
		OperacionRepuesta resp = new OperacionRepuesta();
		String r = "";

		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, usuario.getContrasenya());
		usuario.setContrasenya(hash);

		try {
			r = autenticacionService.registrar(usuario.getUsuario(), usuario.getContrasenya());
			if (r == "YA ESTA REGISTRADO") {
				resp.setSuccessfull(false);
				resp.setRespuesta("El usuario ya se encuentra registrado");
			} else {
				resp.setSuccessfull(true);
				resp.setRespuesta("Usuario registrado exitosamente. ID: " + r);
			}

		} catch (Exception ex) {
			resp.setSuccessfull(false);
			resp.setRespuesta("Error Exception: " + String.valueOf(ex));
			log.info("error_exception: " + String.valueOf(ex));
		}

		return resp;
	}

}
