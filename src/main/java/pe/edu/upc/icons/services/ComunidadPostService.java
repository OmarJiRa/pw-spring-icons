package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.ComunidadPost;

public interface ComunidadPostService extends CrudService<ComunidadPost, Integer> {
<<<<<<< HEAD
	List<ComunidadPost> findByComunidad(Integer comunidad_id) throws Exception;
=======
	List<ComunidadPost> findByNombre(String nombre) throws Exception;
	List<ComunidadPost> findByDescripcion(String descripcion) throws Exception;
>>>>>>> b7842678a49aa7ff52102a175ac3a50fdc9337ce
}
