package com.example.mimicroauth.domain;

public class TokenRespuesta {
	private String token;
	private String idUsuario;
	private String usuario;
	private String respuesta;
	private boolean successfull;
	
	
	public boolean isSuccessfull() {
		return successfull;
	}
	public void setSuccessfull(boolean successfull) {
		this.successfull = successfull;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
