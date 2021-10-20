package br.com.mpce.sistemadeprotocolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mpce.sistemadeprotocolo.entities.Documento;

public interface DocumentoRepository  extends JpaRepository<Documento, Integer>{

}
