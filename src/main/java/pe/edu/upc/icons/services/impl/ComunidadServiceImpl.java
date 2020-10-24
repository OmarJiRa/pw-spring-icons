package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.Comunidad;
import pe.edu.upc.icons.models.repositories.ComunidadRepository;
import pe.edu.upc.icons.services.ComunidadService;

@Service
public class ComunidadServiceImpl implements ComunidadService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ComunidadRepository comunidadRepository;

	@Transactional
	@Override
	public Comunidad save(Comunidad entity) throws Exception {
		return comunidadRepository.save(entity);
	}

	@Transactional
	@Override
	public Comunidad update(Comunidad entity) throws Exception {
		return comunidadRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		comunidadRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Comunidad> findById(Integer id) throws Exception {
		return comunidadRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Comunidad> findAll() throws Exception {
		return comunidadRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Comunidad> findByNombre(String nombre) throws Exception {
		return comunidadRepository.findByNombreLike(nombre);
	}

}
