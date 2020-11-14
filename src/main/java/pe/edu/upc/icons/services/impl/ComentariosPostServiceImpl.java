package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.ComentariosPost;
import pe.edu.upc.icons.models.repositories.ComentariosPostRepository;
import pe.edu.upc.icons.services.ComentariosPostService;

@Service
public class ComentariosPostServiceImpl implements ComentariosPostService, Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	private ComentariosPostRepository comentariosPostRepository;

	@Transactional
	@Override
	public ComentariosPost save(ComentariosPost entity) throws Exception {
		return comentariosPostRepository.save(entity);
	}

	@Transactional
	@Override
	public ComentariosPost update(ComentariosPost entity) throws Exception {
		return comentariosPostRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		comentariosPostRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<ComentariosPost> findById(Integer id) throws Exception {
		return comentariosPostRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComentariosPost> findAll() throws Exception {
		return comentariosPostRepository.findAll();
	}
	
	/*@Transactional(readOnly = true)
	@Override
	public List<ComentariosPost> findByNombre(String nombre) throws Exception {
		return comentariosPostRepository.findByNombreContaining(nombre);
	}*/

	@Transactional(readOnly = true)
	@Override
	public List<ComentariosPost> findByDescripcion(String descripcion) throws Exception {
		return comentariosPostRepository.findByDescripcionContaining(descripcion);
	}

	@Override
	public List<ComentariosPost> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
