package pe.edu.upc.icons.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	List<Usuario> findByNombresApellidosContaining(String nombresApellidos) throws Exception;
	Optional<Usuario> findByEmail(String email) throws Exception;
	Optional<Usuario> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
