package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.CreadorPost;

@Repository
public interface CreadorPostRepository extends JpaRepository<CreadorPost, Integer>{
	List<CreadorPost> findByNombreContaining(String nombre) throws Exception;

}
