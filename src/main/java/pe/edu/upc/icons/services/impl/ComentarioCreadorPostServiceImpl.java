package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.ComentarioCreadorPost;
import pe.edu.upc.icons.models.repositories.ComentarioCreadorPostRepository;
import pe.edu.upc.icons.services.ComentarioCreadorPostService;

@Service
public class ComentarioCreadorPostServiceImpl implements ComentarioCreadorPostService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ComentarioCreadorPostRepository comentariocreadorpostRepository;

	@Transactional
	@Override
	public ComentarioCreadorPost save(ComentarioCreadorPost entity) throws Exception {
		return comentariocreadorpostRepository.save(entity);
	}

	@Transactional
	@Override
	public ComentarioCreadorPost update(ComentarioCreadorPost entity) throws Exception {
		return comentariocreadorpostRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		comentariocreadorpostRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<ComentarioCreadorPost> findById(Integer id) throws Exception {
		return comentariocreadorpostRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComentarioCreadorPost> findAll() throws Exception {
		return comentariocreadorpostRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComentarioCreadorPost> findByCreador(String creador) throws Exception {
		return comentariocreadorpostRepository.findByCreadorContaining(creador);
	}


}
