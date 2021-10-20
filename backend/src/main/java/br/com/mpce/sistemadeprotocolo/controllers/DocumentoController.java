package br.com.mpce.sistemadeprotocolo.controllers;

import java.net.URI;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.mpce.sistemadeprotocolo.dto.DocumentoDTO;
import br.com.mpce.sistemadeprotocolo.entities.Documento;
import br.com.mpce.sistemadeprotocolo.services.DocumentoService;


@RestController
@RequestMapping(value="/documentos")
public class DocumentoController {
	
	@Autowired
	private DocumentoService service;

	@GetMapping
	public ResponseEntity<Page<DocumentoDTO>> findAll(Pageable pageable){
		Page<DocumentoDTO> lista= service.findAll(pageable);
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert ( @RequestBody DocumentoDTO obj){	
			Documento documento= service.fromDTO(obj);
			service.insert(documento);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Documento> findById(@PathVariable Integer id){	
			Documento obj=service.find(id);
			return ResponseEntity.ok().body(obj);
	}
	

}