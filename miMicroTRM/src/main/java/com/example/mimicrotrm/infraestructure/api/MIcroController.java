package com.example.mimicrotrm.infraestructure.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mimicrotrm.application.Operaciones;
import com.example.mimicrotrm.application.utils.JWTUtil;
import com.example.mimicrotrm.domain.Moneda;
import com.example.mimicrotrm.domain.MonedaRespuesta;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
public class MIcroController {
//	@Value("${trm}")
//	private double trm;
	private static final Logger log = LoggerFactory.getLogger(MIcroController.class);

	@Autowired
	Operaciones operaciones;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/moneda")
	public MonedaRespuesta getMoneda(@RequestBody Moneda moneda, @RequestHeader(value = "Authorization") String jwt) {
		log.info("usuario: " + moneda.getUsuario());
		if (!validarToken(jwt)) {
			log.info("token no valido: " + jwt);
			return null;
		}
		System.out.println("valor: " + moneda.getValor());
		return operaciones.getConversion(moneda);
	}

	private boolean validarToken(String jwt) {
		String id = jwtUtil.getKey(jwt);
		return id != null;
	}

//	@GetMapping("/dolares/{dolares}")
//	public MonedaRespuesta getColones(@PathVariable double dolares) {
//		log.info("dolares: " + dolares);
//		return new Operaciones().getColones(dolares, trm);
//	}
//	
//	@GetMapping("/colones/{colones}")
//	public MonedaRespuesta getDolares(@PathVariable double colones) {
//		log.info("colones: " + colones);
//		return new Operaciones().getDolares(colones, trm);
//	}

}
