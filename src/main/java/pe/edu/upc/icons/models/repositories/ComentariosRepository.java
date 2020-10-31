package pe.edu.upc.icons.models.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer>{
	/*List<Comentarios> findByNombre(String nombre) throws Exception;*/
}
