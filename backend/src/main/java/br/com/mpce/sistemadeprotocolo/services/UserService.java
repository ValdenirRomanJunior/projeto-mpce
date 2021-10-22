package br.com.mpce.sistemadeprotocolo.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.mpce.sistemadeprotocolo.security.UserSS;

public class UserService {

	public static UserSS authenticated () {
		try {
		return  (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
