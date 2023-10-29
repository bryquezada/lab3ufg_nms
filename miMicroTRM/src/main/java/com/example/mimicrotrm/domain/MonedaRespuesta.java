package com.example.mimicrotrm.domain;

public class MonedaRespuesta {
	public double cantidad;
	public double resultado;
	boolean successfull;
	String respuesta;
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public boolean isSuccessfull() {
		return successfull;
	}
	public void setSuccessfull(boolean successfull) {
		this.successfull = successfull;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
}
