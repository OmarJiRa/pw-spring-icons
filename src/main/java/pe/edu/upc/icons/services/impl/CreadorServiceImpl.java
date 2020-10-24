package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.Creador;
import pe.edu.upc.icons.models.repositories.CreadorRepository;
import pe.edu.upc.icons.services.CreadorService;

@Service
public class CreadorServiceImpl implements CreadorService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CreadorRepository creadorRepository;

	@Transactional
	@Override
	public Creador save(Creador entity) throws Exception {
		return creadorRepository.save(entity);
	}

	@Transactional
	@Override
	public Creador update(Creador entity) throws Exception {
		return creadorRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		creadorRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Creador> findById(Integer id) throws Exception {
		return creadorRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Creador> findAll() throws Exception {
		return creadorRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Creador> findByNombresApellidos(String nombresApellidos) throws Exception {
		return creadorRepository.findByNombresApellidosContaining(nombresApellidos);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Creador> findByEmail(String email) throws Exception {
		return creadorRepository.findByEmail(email);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Creador> findByNumeroDocumento(String numeroDocumento) throws Exception {
		return creadorRepository.findByNumeroDocumento(numeroDocumento);
	}

}
