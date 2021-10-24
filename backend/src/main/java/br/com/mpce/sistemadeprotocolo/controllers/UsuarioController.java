package br.com.mpce.sistemadeprotocolo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mpce.sistemadeprotocolo.dto.UsuarioDTO;
import br.com.mpce.sistemadeprotocolo.entities.Usuario;
import br.com.mpce.sistemadeprotocolo.services.UsuarioService;


@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	

	@Autowired
	private UsuarioService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Usuario usuario= service.find(id);
		return ResponseEntity.ok().body(usuario);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert ( @RequestBody UsuarioDTO obj){
			Usuario usuario=service.fromDTO(obj);
			service.insert(usuario);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
	