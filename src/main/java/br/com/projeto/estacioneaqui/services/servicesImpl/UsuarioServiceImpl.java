package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.estacioneaqui.models.Usuario;
import br.com.projeto.estacioneaqui.repositories.UsuarioRepository;
import br.com.projeto.estacioneaqui.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Usuario detalhar(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Boolean usuarioExiste(Long id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public Usuario atualizar(Long id, Usuario alteracao) {

		Usuario usuario = detalhar(id);
		alteracao.setId(usuario.getId());
		
		return usuarioRepository.save(alteracao);
	}

	@Override
	@Transactional
	public boolean remover(Long id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Optional<Usuario> buscaPorEmail(String username) {
		return usuarioRepository.findByEmail(username);
	}

}
