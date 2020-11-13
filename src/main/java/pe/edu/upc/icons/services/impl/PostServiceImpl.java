package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.Creador;
import pe.edu.upc.icons.models.entities.Post;
import pe.edu.upc.icons.models.repositories.PostRepository;
import pe.edu.upc.icons.services.PostService;

@Service
public class PostServiceImpl implements PostService, Serializable {


	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PostRepository postRepository;

	@Transactional
	@Override
	public Post save(Post entity) throws Exception {
		return postRepository.save(entity);
	}

	@Transactional
	@Override
	public Post update(Post entity) throws Exception {
		return postRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		postRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Post> findById(Integer id) throws Exception {
		return postRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Post> findAll() throws Exception {
		return postRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Post> findByNombre(String nombre) throws Exception {
		return postRepository.findByNombreContaining(nombre);
	}

	@Override
	public List<Post> findByExclusivo(Boolean exclusivo) throws Exception {
		return postRepository.findByExclusivo(exclusivo);
	}

	@Override
	public List<Post> findByCreador(Creador creador) throws Exception {
		return postRepository.findByCreador(creador);
	}

}
