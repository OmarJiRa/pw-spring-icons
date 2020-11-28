package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.Post;
import pe.edu.upc.icons.models.entities.UsuarioPost;
import pe.edu.upc.icons.models.repositories.UsuarioPostRepository;
import pe.edu.upc.icons.services.UsuarioPostService;

@Service
public class UsuarioPostServiceImpl implements UsuarioPostService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioPostRepository upRepository;

	@Transactional
	@Override
	public UsuarioPost save(UsuarioPost entity) throws Exception {
		return upRepository.save(entity);
	}

	@Transactional
	@Override
	public UsuarioPost update(UsuarioPost entity) throws Exception {
		return upRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		upRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<UsuarioPost> findById(Integer id) throws Exception {
		return upRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<UsuarioPost> findAll() throws Exception {
		return upRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<UsuarioPost> findByPost(Post post) throws Exception {
		return upRepository.findByPost(post);

	}
}