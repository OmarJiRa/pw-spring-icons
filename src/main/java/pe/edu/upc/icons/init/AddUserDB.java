/*package pe.edu.upc.icons.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.icons.models.entities.User;
import pe.edu.upc.icons.models.repositories.AuthorityRepository;
import pe.edu.upc.icons.models.repositories.UserRepository;
import pe.edu.upc.icons.utils.Segmento;

@Service
public class AddUserDB implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String password = bcpe.encode("usuario");
		
		User usuario1 = new User();
		usuario1.setUsername("usuario1");
		usuario1.setPassword( password );
		usuario1.setSegmento(Segmento.USUARIO);
		usuario1.setIdSegmento(1);
		usuario1.setEnable(true);
		
		User usuario2 = new User();
		usuario2.setUsername("usuario2");
		usuario2.setPassword( password );
		usuario2.setSegmento(Segmento.USUARIO);
		usuario2.setIdSegmento(2);
		usuario2.setEnable(true);
		
		User usuario3 = new User();
		usuario3.setUsername("usuario3");
		usuario3.setPassword( password );
		usuario3.setSegmento(Segmento.USUARIO);
		usuario3.setIdSegmento(3);
		usuario3.setEnable(true);
		
		BCryptPasswordEncoder bcpeCreador = new BCryptPasswordEncoder();
		String passwordC = bcpeCreador.encode("creador");
		
		User creador1 = new User();
		creador1.setUsername("creador1");
		creador1.setPassword(passwordC);
		creador1.setSegmento(Segmento.CREADOR);
		creador1.setIdSegmento(4);
		creador1.setEnable(true);
		
		User creador2 = new User();
		creador2.setUsername("creador2");
		creador2.setPassword(passwordC);
		creador2.setSegmento(Segmento.CREADOR);
		creador2.setIdSegmento(5);
		creador2.setEnable(true);
		
		User creador3 = new User();
		creador3.setUsername("creador3");
		creador3.setPassword(passwordC);
		creador3.setSegmento(Segmento.CREADOR);
		creador3.setIdSegmento(6);
		creador3.setEnable(true);
		
		usuario1.addAuthority("ROLE_USUARIO");
		usuario2.addAuthority("ROLE_USUARIO");
		usuario3.addAuthority("ROLE_USUARIO");
		creador1.addAuthority("ROLE_CREADOR");
		creador2.addAuthority("ROLE_CREADOR");
		creador3.addAuthority("ROLE_CREADOR");
		
		usuario1.addAuthority("ACCESS_EXCLUSIVE");
		usuario2.addAuthority("ACCESS_EXCLUSIVE");
		
		userRepository.save(usuario1);
		userRepository.save(usuario2);
		userRepository.save(usuario3);
		
		userRepository.save(creador1);
		userRepository.save(creador2);
		userRepository.save(creador3);
		
	}

}*/
