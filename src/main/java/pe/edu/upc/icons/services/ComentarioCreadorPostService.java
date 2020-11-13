package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.ComentarioCreadorPost;

public interface ComentarioCreadorPostService extends CrudService<ComentarioCreadorPost, Integer>{
	List<ComentarioCreadorPost> findByCreador(String creador) throws Exception;
}