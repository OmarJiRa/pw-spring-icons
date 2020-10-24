package pe.edu.upc.icons.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.icons.models.entities.Usuario;
import pe.edu.upc.icons.models.repositories.UsuarioRepository;
import pe.edu.upc.icons.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	@Override
	public Usuario save(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public Usuario update(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		usuarioRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		return usuarioRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() throws Exception {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findByNombresApellidos(String nombresApellidos) throws Exception {
		return usuarioRepository.findByNombresApellidosContaining(nombresApellidos);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findByEmail(String email) throws Exception {
		return usuarioRepository.findByEmail(email);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findByNumeroDocumento(String numeroDocumento) throws Exception {
		return usuarioRepository.findByNumeroDocumento(numeroDocumento);
	}
}
