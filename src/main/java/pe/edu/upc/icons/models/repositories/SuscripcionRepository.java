package pe.edu.upc.icons.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.Suscripcion;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion, Integer> {

}
