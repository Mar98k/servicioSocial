package com.ss.siase.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.siase.config.JwtTokenUtil;
import com.ss.siase.modelos.LoginModel;
import com.ss.siase.modelos.TokenRespuesta;
import com.ss.siase.service.implementacion.TipoLoginService;

@RestController
@CrossOrigin
@RequestMapping("/sistema")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService administradorDetailsService;
	
	@Autowired
	private TipoLoginService tipoLoginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginModel login)
			throws Exception {
		
		UserDetails userDetails = administradorDetailsService.loadUserByUsername(login.getUsuario());
		autenticar(login.getUsuario(), login.getContrasena());
		
		int tipoLogin = this.tipoLoginService.getTipoLogin();
		final String token = jwtTokenUtil.generateToken(userDetails, tipoLogin);

		return ResponseEntity.ok(new TokenRespuesta(token, tipoLogin));
	}

	private void autenticar(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
