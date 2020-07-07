package com.ss.siase.service.implementacion;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.siase.dao.AlumnoDAO;
import com.ss.siase.modelos.Alumno;
import com.ss.siase.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoDAO alumnoDAO;
	
	@Override
	@Transactional
	public Alumno consultarPorUsuario(String usuario) {
		return this.alumnoDAO.consultarPorUsuario(usuario);
	}

}
