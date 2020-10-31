package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.ComunidadPost;

@Repository
public interface ComunidadPostRepository extends JpaRepository<ComunidadPost, Integer>{
	List<ComunidadPost> findByComunidad(Integer id) throws Exception;
}
