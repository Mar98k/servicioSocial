package com.ss.siase.service.implementacion;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ss.siase.dao.AdministradorDAO;
import com.ss.siase.modelos.Administrador;
import com.ss.siase.service.AdministradorService;

@Repository
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	private AdministradorDAO administradorDAO;
	
	@Override
	@Transactional
	public Administrador consultarPorUsuario(String usuario) {
		return this.administradorDAO.consultarPorUsuario(usuario);
	}

}
