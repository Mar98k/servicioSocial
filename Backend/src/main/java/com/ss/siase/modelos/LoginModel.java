package com.ss.siase.modelos;

import java.io.Serializable;

public class LoginModel implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	private String usuario;
	private String contrasena;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
