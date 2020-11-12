package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.CreadorPost;
import pe.edu.upc.icons.models.repositories.CreadorPostRepository;
import pe.edu.upc.icons.services.CreadorPostService;

@Service
public class CreadorPostServiceImpl implements CreadorPostService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CreadorPostRepository creadorpostRepository;

	@Transactional
	@Override
	public CreadorPost save(CreadorPost entity) throws Exception {
		return creadorpostRepository.save(entity);
	}

	@Transactional
	@Override
	public CreadorPost update(CreadorPost entity) throws Exception {
		return creadorpostRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		creadorpostRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<CreadorPost> findById(Integer id) throws Exception {
		return creadorpostRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CreadorPost> findAll() throws Exception {
		return creadorpostRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<CreadorPost> findByNombre(String nombre) throws Exception {
		return creadorpostRepository.findByNombreContaining(nombre);
	}

}
