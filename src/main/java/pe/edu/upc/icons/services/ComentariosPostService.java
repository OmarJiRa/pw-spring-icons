package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.ComentariosPost;

public interface ComentariosPostService extends CrudService<ComentariosPost, Integer> {
	List<ComentariosPost> findByNombre(String nombre) throws Exception;
	List<ComentariosPost> findByDescripcion(String descripcion) throws Exception;
}
