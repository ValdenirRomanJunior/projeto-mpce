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
public class UserDetailServiceImpl implements UserDetailsService{

	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario= UsuarioRepository.findByEmail(email);
			if(usuario==null) {
				throw new UsernameNotFoundException(email);
			}
		
		return new UserSS(usuario.getId(),usuario.getEmail(),usuario.getSenha(),usuario.getPerfis());
	}

}
