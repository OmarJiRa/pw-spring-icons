package pe.edu.upc.icons.services;

import java.util.List;

import pe.edu.upc.icons.models.entities.ComunidadDetalle;

public interface ComunidadDetalleService extends CrudService<ComunidadDetalle, Integer>{
	List<ComunidadDetalle> findByNombre(String nombre) throws Exception;
	List<ComunidadDetalle> findByDescripcion(String descripcion) throws Exception;
}
