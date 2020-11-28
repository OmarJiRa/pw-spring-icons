package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.ComunidadDetalle;
import pe.edu.upc.icons.models.repositories.ComunidadDetalleRepository;
import pe.edu.upc.icons.services.ComunidadDetalleService;

@Service
public class ComunidadDetalleServiceImpl implements ComunidadDetalleService, Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ComunidadDetalleRepository comunidadDetalleRepository;

	@Transactional
	@Override
	public ComunidadDetalle save(ComunidadDetalle entity) throws Exception {
		return comunidadDetalleRepository.save(entity);
	}

	@Transactional
	@Override
	public ComunidadDetalle update(ComunidadDetalle entity) throws Exception {
		return comunidadDetalleRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		comunidadDetalleRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<ComunidadDetalle> findById(Integer id) throws Exception {
		return comunidadDetalleRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComunidadDetalle> findAll() throws Exception {
		return comunidadDetalleRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComunidadDetalle> findByNombre(String nombre) throws Exception {
		return comunidadDetalleRepository.findByNombreContaining(nombre);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComunidadDetalle> findByDescripcion(String descripcion) throws Exception {
		return comunidadDetalleRepository.findByDescripcionContaining(descripcion);
	}

}
