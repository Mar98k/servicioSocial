package com.ss.siase.service.implementacion;

import org.springframework.stereotype.Component;

@Component
public class TipoLoginService {

	private int tipoLogin;

	public int getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(int tipoLogin) {
		this.tipoLogin = tipoLogin;
	}
	
}
