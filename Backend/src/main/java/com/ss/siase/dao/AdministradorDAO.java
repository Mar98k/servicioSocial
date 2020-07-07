package com.ss.siase.dao;

import com.ss.siase.modelos.Administrador;

public interface AdministradorDAO {
	public Administrador consultarPorUsuario(String usuario);
}
