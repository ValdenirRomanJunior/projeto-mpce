package br.com.mpce.sistemadeprotocolo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mpce.sistemadeprotocolo.entities.Usuario;
import br.com.mpce.sistemadeprotocolo.enums.Perfil;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	

	@GetMapping(value="{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Usuario usuario1 = new Usuario(id, "vromanjunior@outlook.com", pe.encode("123"));
		usuario1.addPerfil(Perfil.ADMIN);
		return ResponseEntity.ok().body(usuario1);
		
	}
	
}
