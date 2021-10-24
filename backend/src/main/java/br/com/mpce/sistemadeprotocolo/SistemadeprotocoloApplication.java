package br.com.mpce.sistemadeprotocolo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.mpce.sistemadeprotocolo.entities.Documento;
import br.com.mpce.sistemadeprotocolo.entities.Usuario;
import br.com.mpce.sistemadeprotocolo.enums.Perfil;
import br.com.mpce.sistemadeprotocolo.repositories.DocumentoRepository;
import br.com.mpce.sistemadeprotocolo.repositories.UsuarioRepository;


@SpringBootApplication
public class SistemadeprotocoloApplication implements CommandLineRunner {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public static void main(String[] args) {
		SpringApplication.run(SistemadeprotocoloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario = new Usuario(null,"vromanjunior@outlook.com", pe.encode("123"));
		usuario.addPerfil(Perfil.ADMIN);
		
		Documento documento = new Documento(null,1,2021,LocalDate.now(),"defensoria","qualquer assunto","joão");
		
		documentoRepository.save(documento);
		
		
		
		usuarioRepository.save(usuario);
	
		
	}
	
	

}
