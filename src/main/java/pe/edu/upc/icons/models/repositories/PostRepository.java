package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByNombre(String nombre) throws Exception;
}
