package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.Comentarios;
import pe.edu.upc.icons.models.repositories.ComentariosRepository;
import pe.edu.upc.icons.services.ComentariosService;

@Service
public class ComentariosServiceImpl implements ComentariosService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ComentariosRepository comentarioRepository;

	@Transactional
	@Override
	public Comentarios save(Comentarios entity) throws Exception {
		return comentarioRepository.save(entity);
	}

	@Transactional
	@Override
	public Comentarios update(Comentarios entity) throws Exception {
		return comentarioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		comentarioRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Comentarios> findById(Integer id) throws Exception {
		return comentarioRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Comentarios> findAll() throws Exception {
		return comentarioRepository.findAll();
	}



}
