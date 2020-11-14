package pe.edu.upc.icons.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Creador;

@Repository
public interface CreadorRepository extends JpaRepository<Creador, Integer> {
	List<Creador> findByNombresApellidosContaining(String nombresApellidos) throws Exception;
	Optional<Creador> findByEmail(String email) throws Exception;
	Optional<Creador> findByNumeroDocumento(String numeroDocumento) throws Exception;
	
	@Query("SELECT COUNT(u.usuario) " + 
			"FROM UsuarioPost u JOIN Post p ON u.post = p.id JOIN Creador c ON c.id = p.creador " + 
			"WHERE c.id = 1 AND u.meGusta = true")
	Integer numeroMeGusta(Integer id) throws Exception;
	
	@Query("SELECT COUNT(u.usuario) "
			  + "FROM UsuarioPost u JOIN Post p ON u.post = p.id JOIN Creador c ON c.id = p.creador "
			  + "WHERE u.comentario != ''")
	Integer numeroComentarios(Integer id) throws Exception;
	
	@Query("SELECT COUNT(s.usuario) FROM Seguimiento s WHERE s.creador = 1")
	Integer numeroSeguidores(Integer id) throws Exception;
	
	@Query("SELECT COUNT(s.usuario) FROM Suscripcion s WHERE s.creador = 1")
	Integer numeroSuscriptores(Integer id) throws Exception;
}
