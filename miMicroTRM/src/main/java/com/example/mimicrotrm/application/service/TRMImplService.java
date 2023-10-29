package com.example.mimicrotrm.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mimicrotrm.application.repository.ITRMREpo;
import com.example.mimicrotrm.domain.MonedaRespuesta;

@Service
public class TRMImplService implements ITRMService{
	
	@Autowired
	private ITRMREpo repo;

	@Override
	public double buscar(String moneda, String intercambio) {
		return repo.buscar(moneda, intercambio);
	}

}
