package pe.edu.upc.icons.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.icons.models.entities.MedioPago;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPago, Integer>{
	Optional<MedioPago> findByNumero(String numero) throws Exception;
}
