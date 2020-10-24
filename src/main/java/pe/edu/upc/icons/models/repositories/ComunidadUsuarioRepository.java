package pe.edu.upc.icons.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.ComunidadUsuario;

@Repository
public interface ComunidadUsuarioRepository extends JpaRepository<ComunidadUsuario, Integer> {
	
}
