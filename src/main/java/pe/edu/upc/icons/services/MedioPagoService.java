package pe.edu.upc.icons.services;

import java.util.Optional;

import pe.edu.upc.icons.models.entities.MedioPago;

public interface MedioPagoService extends CrudService<MedioPago, Integer> {
	Optional<MedioPago> findByNumero(String numero) throws Exception;
}
