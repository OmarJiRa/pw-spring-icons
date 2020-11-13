package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.Creador;
import pe.edu.upc.icons.models.entities.Post;

public interface PostService extends CrudService<Post, Integer> {
	List<Post> findByNombre(String nombre) throws Exception;
	List<Post> findByExclusivo (Boolean exclusivo) throws Exception;
	List<Post> findByCreador (Creador creador) throws Exception;
}
