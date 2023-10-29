package com.example.mimicrotrm.domain;

public class Moneda {
	private String usuario;
	private String moneda;
	private String intercambio;
	private double valor;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getIntercambio() {
		return intercambio;
	}
	public void setIntercambio(String intercambio) {
		this.intercambio = intercambio;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
