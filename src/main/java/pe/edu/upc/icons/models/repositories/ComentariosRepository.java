package pe.edu.upc.icons.models.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer>{
<<<<<<< HEAD
	
	//List<Comentarios> findByNombreLike(String nombre) throws Exception;

=======
	/*List<Comentarios> findByNombre(String nombre) throws Exception;*/
>>>>>>> 2d45f0f4288a82084695a3ea1835c2c83ac57b07
}
