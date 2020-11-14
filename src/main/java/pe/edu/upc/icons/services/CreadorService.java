package pe.edu.upc.icons.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.icons.models.entities.Creador;

public interface CreadorService extends CrudService<Creador, Integer> {
	List<Creador> findByNombresApellidos(String nombresApellidos) throws Exception;
	Optional<Creador> findByEmail(String email) throws Exception;
	Optional<Creador> findByNumeroDocumento(String numeroDocumento) throws Exception;
	Integer numeroMeGusta(Integer id) throws Exception;
	Integer numeroComentarios(Integer id) throws Exception;
	Integer numeroSeguidores(Integer id) throws Exception;
	Integer numeroSuscriptores(Integer id) throws Exception;
}
