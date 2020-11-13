package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.ComentarioCreadorPost;

@Repository
public interface ComentarioCreadorPostRepository extends JpaRepository<ComentarioCreadorPost, Integer> {
	List<ComentarioCreadorPost> findByCreadorContaining(String creador) throws Exception;
}