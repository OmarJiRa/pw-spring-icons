package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.CreadorPost;

public interface CreadorPostService extends CrudService<CreadorPost, Integer>{
	List<CreadorPost> findByNombre(String nombre) throws Exception;
}
