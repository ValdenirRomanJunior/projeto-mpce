package br.com.mpce.sistemadeprotocolo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.mpce.sistemadeprotocolo.entities.Documento;

public class DocumentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer codigo;
	private Integer ano;
	private LocalDate date;
	
	@NotEmpty(message="Campo obrigatório")
	@Length(min=5, max=80, message="o tamanho deve ser entre 5 e 80 caracteres")
	private String origem;
	private String assunto;
	private String solicitante;
	
	
	
	public DocumentoDTO() {
		
	}

	
	public DocumentoDTO(Documento entity) {
		this.id=entity.getId();
		this.codigo=entity.getCodigo();
		this.ano=entity.getAno();
		this.date=entity.getDate();
		this.origem=entity.getOrigem();
		this.assunto=entity.getAssunto();
		this.solicitante=entity.getSolicitante();
	}




	public DocumentoDTO(Integer id, Integer codigo, Integer ano, LocalDate date, String origem, String assunto,
			String solicitante) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.ano = ano;
		this.date = date;
		this.origem = origem;
		this.assunto = assunto;
		this.solicitante = solicitante;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public Integer getAno() {
		return ano;
	}




	public void setAno(Integer ano) {
		this.ano = ano;
	}




	public LocalDate getDate() {
		return date;
	}




	public void setDate(LocalDate date) {
		this.date = date;
	}




	public String getOrigem() {
		return origem;
	}




	public void setOrigem(String origem) {
		this.origem = origem;
	}




	public String getAssunto() {
		return assunto;
	}




	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}




	public String getSolicitante() {
		return solicitante;
	}




	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}








	
}
