package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.ComunidadPost;

public interface ComunidadPostService extends CrudService<ComunidadPost, Integer> {
	List<ComunidadPost> findByComunidad(Integer comunidad_id) throws Exception;
}
