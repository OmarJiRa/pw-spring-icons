  
package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.ComunidadPost;
import pe.edu.upc.icons.models.entities.Comunidad;

@Repository
public interface ComunidadPostRepository extends JpaRepository<ComunidadPost, Integer>{
	List<ComunidadPost> findByNombreContaining(String nombre) throws Exception;
	List<ComunidadPost> findByDescripcionContaining(String descripcion) throws Exception;
	List<ComunidadPost> findByComunidad (Comunidad comunidad) throws Exception;
}