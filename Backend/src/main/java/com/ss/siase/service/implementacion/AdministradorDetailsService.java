package com.ss.siase.service.implementacion;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss.siase.constantes.Constantes;
import com.ss.siase.modelos.Administrador;
import com.ss.siase.modelos.Alumno;
import com.ss.siase.modelos.Maestro;
import com.ss.siase.service.AdministradorService;
import com.ss.siase.service.AlumnoService;
import com.ss.siase.service.MaestroService;


@Service
public class AdministradorDetailsService implements UserDetailsService {
	
	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private MaestroService maestroService;
	
	@Autowired
	private TipoLoginService tipoLoginService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Administrador administrador = this.administradorService.consultarPorUsuario(username);
		Alumno alumno = this.alumnoService.consultarPorUsuario(username);
		Maestro maestro = this.maestroService.consultarPorUsuario(username);
		
		if (administrador != null) {
			this.tipoLoginService.setTipoLogin(Constantes.LOGIN_ADMINISTRADOR);
			return new User(administrador.getUsuario(), administrador.getContrasena(), new ArrayList<>());
		} else if (alumno != null) {
			this.tipoLoginService.setTipoLogin(Constantes.LOGIN_ALUMNO);
			return new User(alumno.getUsuario(), alumno.getContrasena(), new ArrayList<>());
		} else if (maestro != null) {
			this.tipoLoginService.setTipoLogin(Constantes.LOGIN_MAESTRO);
			return new User(maestro.getUsuario(), maestro.getContrasena(), new ArrayList<>());
		} else {			
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}