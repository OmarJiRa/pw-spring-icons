package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.Post;
import pe.edu.upc.icons.models.entities.UsuarioPost;

public interface UsuarioPostService extends CrudService<UsuarioPost, Integer> {
	List<UsuarioPost> findByPost (Post post) throws Exception;
}
