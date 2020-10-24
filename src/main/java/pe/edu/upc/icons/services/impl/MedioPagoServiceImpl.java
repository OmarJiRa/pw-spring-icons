package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.MedioPago;
import pe.edu.upc.icons.models.repositories.MedioPagoRepository;
import pe.edu.upc.icons.services.MedioPagoService;

@Service
public class MedioPagoServiceImpl implements MedioPagoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MedioPagoRepository medioPagoRepository;

	@Transactional
	@Override
	public MedioPago save(MedioPago entity) throws Exception {
		return medioPagoRepository.save(entity);
	}

	@Transactional
	@Override
	public MedioPago update(MedioPago entity) throws Exception {
		return medioPagoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		medioPagoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<MedioPago> findById(Integer id) throws Exception {
		return medioPagoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<MedioPago> findAll() throws Exception {
		return medioPagoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<MedioPago> findByNumero(String numero) throws Exception {
		return findByNumero(numero);
	}

}
