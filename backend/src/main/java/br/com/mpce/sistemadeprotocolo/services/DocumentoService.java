package br.com.mpce.sistemadeprotocolo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mpce.sistemadeprotocolo.dto.DocumentoDTO;
import br.com.mpce.sistemadeprotocolo.entities.Documento;
import br.com.mpce.sistemadeprotocolo.repositories.DocumentoRepository;
import br.com.mpce.sistemadeprotocolo.services.exceptions.ObjectNotFoundException;


@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository repository;
	
	
	public Page<DocumentoDTO> findAll(Pageable pageable){	
		Page<Documento> result =repository.findAll(pageable);	
		return result.map(x -> new DocumentoDTO(x));
		
	}
	
		public Documento insert (Documento obj) {
			obj.setCodigo(geraCodigo()+1);		
	    	return repository.save(obj);
	}

			public Integer geraCodigo() {
			List<Documento> documentos =repository.findAll();
			for( int i=0; i<documentos.size(); i++) {
			if(i== documentos.size() -1) {
				Documento documento= documentos.get(i);		
				return documento.getCodigo();		
			}
				
			}
			return null;
			
		
	}
			
			public Documento find(Integer id) {	
				Optional<Documento> obj =repository.findById(id);		
					return obj.orElseThrow(()-> new ObjectNotFoundException
							("objeto nao encontrado Id:" +id + ",Tipo:" + Documento.class.getName()));	
				
			}

	public Documento fromDTO(DocumentoDTO entity) {
	return  new Documento(entity.getId(),entity.getCodigo(),entity.getAno(),entity.getDate()
			,entity.getAssunto(),entity.getOrigem(),entity.getSolicitante());
}
}