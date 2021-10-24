package br.com.mpce.sistemadeprotocolo.dto;

import java.io.Serializable;

import br.com.mpce.sistemadeprotocolo.entities.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Integer id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	
	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

	
}
