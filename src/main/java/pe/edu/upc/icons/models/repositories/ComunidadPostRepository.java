package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.ComunidadPost;

@Repository
public interface ComunidadPostRepository extends JpaRepository<ComunidadPost, Integer>{
<<<<<<< HEAD
	List<ComunidadPost> findByComunidad(Integer id) throws Exception;
=======
	List<ComunidadPost> findByNombreContaining(String nombre) throws Exception;
	List<ComunidadPost> findByDescripcionContaining(String descripcion) throws Exception;
>>>>>>> b7842678a49aa7ff52102a175ac3a50fdc9337ce
}
