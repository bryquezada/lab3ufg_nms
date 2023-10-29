package com.example.mimicrotrm.domain;

public class TRM {
	private int id;
	private String moneda;
	private String intercambio;
	private double valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
