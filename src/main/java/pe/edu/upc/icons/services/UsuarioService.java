package pe.edu.upc.icons.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.icons.models.entities.Seguimiento;
import pe.edu.upc.icons.models.entities.Suscripcion;
import pe.edu.upc.icons.models.entities.Usuario;

public interface UsuarioService extends CrudService<Usuario, Integer> {
	List<Usuario> findByNombresApellidos(String nombresApellidos) throws Exception;
	Optional<Usuario> findByEmail(String email) throws Exception;
	Optional<Usuario> findByNumeroDocumento(String numeroDocumento) throws Exception;
	Optional<Seguimiento> setSeguimiento(Integer usuarioId, Integer creadorId);
	Optional<Suscripcion> setSuscripcion(Integer usuarioId, Integer creadorId);
}
