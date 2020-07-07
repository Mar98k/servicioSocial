package com.ss.siase.service.implementacion;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.siase.dao.MaestroDAO;
import com.ss.siase.modelos.Maestro;
import com.ss.siase.service.MaestroService;

@Service
public class MaestroServiceImpl implements MaestroService {

	@Autowired
	private MaestroDAO maestroDAO;
	
	@Override
	@Transactional
	public Maestro consultarPorUsuario(String usuario) {
		return this.maestroDAO.consultarPorUsuario(usuario);
	}

}
