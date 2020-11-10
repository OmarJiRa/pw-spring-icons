package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.ComunidadPost;

public interface ComunidadPostService extends CrudService<ComunidadPost, Integer> {
	List<ComunidadPost> findByNombre(String nombre) throws Exception;
	List<ComunidadPost> findByDescripcion(String descripcion) throws Exception;
}
