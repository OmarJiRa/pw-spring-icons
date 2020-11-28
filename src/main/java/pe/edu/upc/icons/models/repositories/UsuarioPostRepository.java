package pe.edu.upc.icons.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Post;
import pe.edu.upc.icons.models.entities.UsuarioPost;

@Repository
public interface UsuarioPostRepository extends JpaRepository<UsuarioPost, Integer> {
	List<UsuarioPost> findByPost (Post post) throws Exception;
}
