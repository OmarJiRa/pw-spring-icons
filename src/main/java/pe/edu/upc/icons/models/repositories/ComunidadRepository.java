package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Comunidad;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Integer> {
	List<Comunidad> findByNombreContaining(String nombre) throws Exception;
	List<Comunidad> findByTemaContaining(String tema) throws Exception;
}