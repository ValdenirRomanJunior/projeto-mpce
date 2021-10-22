package br.com.mpce.sistemadeprotocolo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mpce.sistemadeprotocolo.entities.Usuario;
import br.com.mpce.sistemadeprotocolo.repositories.UsuarioRepository;
import br.com.mpce.sistemadeprotocolo.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario1 = repository.findByEmail(email);
		if(usuario1==null) {
			throw new UsernameNotFoundException(email);
		}
			
		return new UserSS(usuario1.getId(),usuario1.getEmail(),usuario1.getSenha(),usuario1.getPerfis());
	}

}
