package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.Comentarios;

public interface ComentariosService extends CrudService<Comentarios, Integer> {
	List<Comentarios> findByNombre(String nombre) throws Exception;
}
