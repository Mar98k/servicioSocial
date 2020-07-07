package com.ss.siase.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ss.siase.config.JwtTokenUtil;
import com.ss.siase.constantes.Constantes;
import com.ss.siase.modelos.Administrador;
import com.ss.siase.modelos.Alumno;
import com.ss.siase.modelos.Maestro;
import com.ss.siase.modelos.Administrador.VistaPerfil;
import com.ss.siase.service.AdministradorService;
import com.ss.siase.service.AlumnoService;
import com.ss.siase.service.MaestroService;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private MaestroService maestroService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@JsonView(VistaPerfil.class)
	@GetMapping("/consultarPerfil")
	public ResponseEntity<?> consultarPerfil(HttpServletRequest request)
			throws Exception {
		
		final String requestTokenHeader = request.getHeader("Authorization");

		String jwtToken = null;
		String usuario = null;
		int tipoPerfil = 0;
		
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			usuario = jwtTokenUtil.getUsernameFromToken(jwtToken);
			tipoPerfil = jwtTokenUtil.getPerfilFromToken(jwtToken);
		} else {
			throw new Exception("JWT Token does not begin with Bearer String");
		}
		
		switch (tipoPerfil) {
		case Constantes.LOGIN_ADMINISTRADOR:
			Administrador administrador = this.administradorService.consultarPorUsuario(usuario);
			return ResponseEntity.ok(administrador);
		case Constantes.LOGIN_ALUMNO:
			Alumno alumno = this.alumnoService.consultarPorUsuario(usuario);
			return ResponseEntity.ok(alumno);
		case Constantes.LOGIN_MAESTRO:
			Maestro maestro = this.maestroService.consultarPorUsuario(usuario);
			return ResponseEntity.ok(maestro);
		default:
			throw new Exception("Tipo Perfil no Valido");
		}

	}
	
}
