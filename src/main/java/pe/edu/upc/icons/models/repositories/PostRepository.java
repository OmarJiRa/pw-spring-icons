package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Creador;
import pe.edu.upc.icons.models.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByNombreContaining(String nombre) throws Exception;
	List<Post> findByExclusivo (Boolean exclusivo) throws Exception;
	List<Post> findByCreador (Creador creador) throws Exception;
}
