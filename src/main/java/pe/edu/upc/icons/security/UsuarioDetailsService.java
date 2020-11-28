package pe.edu.upc.icons.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.upc.icons.models.entities.User;
import pe.edu.upc.icons.models.repositories.UserRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UsuarioDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Optional<User> optional = this.userRepository.findByUsername(username);
			if (optional.isPresent()) {
				UsuarioDetails usuarioDetails = new UsuarioDetails( optional.get() );
				return usuarioDetails;
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("El usuario ingresado no existe");	
	}

}
