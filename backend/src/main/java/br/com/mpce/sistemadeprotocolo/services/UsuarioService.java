package br.com.mpce.sistemadeprotocolo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mpce.sistemadeprotocolo.dto.DocumentoDTO;
import br.com.mpce.sistemadeprotocolo.dto.UsuarioDTO;
import br.com.mpce.sistemadeprotocolo.entities.Usuario;
import br.com.mpce.sistemadeprotocolo.enums.Perfil;
import br.com.mpce.sistemadeprotocolo.repositories.UsuarioRepository;
import br.com.mpce.sistemadeprotocolo.security.UserSS;
import br.com.mpce.sistemadeprotocolo.services.exceptions.AuthorizationException;
import br.com.mpce.sistemadeprotocolo.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
		public Usuario find (Integer id) {
		
				UserSS user= UserService.authenticated();
				
				if(user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
					throw new AuthorizationException("Acesso negado");
				}
		Optional<Usuario> obj =repo.findById(id);		
		return obj.orElseThrow(()-> new ObjectNotFoundException
				("objeto nao encontrado Id:" +id + ",Tipo:" + Usuario.class.getName()));	
	
}
		public Usuario fromDTO(UsuarioDTO obj) {
			return  new Usuario(obj.getId(),obj.getEmail(),pe.encode(obj.getSenha()));
			
		}
		public void insert (Usuario usuario) {
			repo.save(usuario);
		}
}