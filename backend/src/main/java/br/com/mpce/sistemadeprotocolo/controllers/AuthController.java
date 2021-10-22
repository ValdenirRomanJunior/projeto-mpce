package br.com.mpce.sistemadeprotocolo.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mpce.sistemadeprotocolo.security.JWTUtil;
import br.com.mpce.sistemadeprotocolo.security.UserSS;
import br.com.mpce.sistemadeprotocolo.services.UserService;

@RestController
@RequestMapping(value="/auth")
public class AuthController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping(value="/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse resp){
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generationToken(user.getUsername());
		resp.addHeader("Authorization","Bearer" + token);
		return ResponseEntity.noContent().build();
	}

}
