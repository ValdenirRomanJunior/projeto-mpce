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

		

			public void deleteById(Integer id) {		
				repository.deleteById(id);
				
				}
			
			public Documento update (Documento obj) {
				Documento novoDocumento=find(obj.getId());
				updateData(novoDocumento, obj);
				return repository.save(novoDocumento);
				
			}

			private void updateData(Documento novoDocumento, Documento obj) {
				novoDocumento.setOrigem(obj.getOrigem());
				novoDocumento.setAssunto(obj.getAssunto());
				novoDocumento.setSolicitante(obj.getSolicitante());
				
			}

			public Documento fromDTO(DocumentoDTO objDTO) {			
				return new Documento(objDTO.getId(),objDTO.getCodigo(),objDTO.getAno(), objDTO.getDate(),
						objDTO.getOrigem(),objDTO.getAssunto(), objDTO.getSolicitante());
			}
		
		}
