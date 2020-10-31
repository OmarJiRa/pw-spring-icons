package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.ComunidadPost;
import pe.edu.upc.icons.models.repositories.ComunidadPostRepository;
import pe.edu.upc.icons.services.ComunidadPostService;

@Service
public class ComunidadPostServiceImpl implements ComunidadPostService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ComunidadPostRepository comunidadPostRepository;

	@Transactional
	@Override
	public ComunidadPost save(ComunidadPost entity) throws Exception {
		return comunidadPostRepository.save(entity);
	}

	@Transactional
	@Override
	public ComunidadPost update(ComunidadPost entity) throws Exception {
		return comunidadPostRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		comunidadPostRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<ComunidadPost> findById(Integer id) throws Exception {
		return comunidadPostRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComunidadPost> findAll() throws Exception {
		return comunidadPostRepository.findAll();
	}

	@Override
	public List<ComunidadPost> findByComunidad(Integer comunidad_id) throws Exception {
		
		return comunidadPostRepository.findByComunidad(comunidad_id);
	}

}
