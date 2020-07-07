package com.ss.siase.modelos;
import java.io.Serializable;
public class TokenRespuesta implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String token;
	private int perfil;
	
	public TokenRespuesta(String token, int perfil) {
		this.token = token;
		this.perfil = perfil;
	}
	
	public String getToken() {
		return this.token;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	
}
