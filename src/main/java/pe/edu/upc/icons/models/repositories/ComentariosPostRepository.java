package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.ComentariosPost;

@Repository
public interface ComentariosPostRepository extends JpaRepository<ComentariosPost, Integer> {
	List<ComentariosPost> findByDescripcionContaining(String descripcion) throws Exception;
}
