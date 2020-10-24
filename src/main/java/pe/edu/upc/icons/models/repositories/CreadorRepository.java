package pe.edu.upc.icons.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Creador;

@Repository
public interface CreadorRepository extends JpaRepository<Creador, Integer> {
	List<Creador> findByNombresApellidos(String nombresApellidos) throws Exception;
	Optional<Creador> findByEmail(String email) throws Exception;
	Optional<Creador> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
