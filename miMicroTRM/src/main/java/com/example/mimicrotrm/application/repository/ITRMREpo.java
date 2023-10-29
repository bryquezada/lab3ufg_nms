package com.example.mimicrotrm.application.repository;

import com.example.mimicrotrm.domain.MonedaRespuesta;

public interface ITRMREpo {
	double buscar(String moneda, String intercambio);
}
