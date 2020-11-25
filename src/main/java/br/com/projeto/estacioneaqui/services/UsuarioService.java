package br.com.projeto.estacioneaqui.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Usuario;

@Service
public interface UsuarioService {

	List<Usuario> listar();

	Usuario cadastrar(Usuario usuario);

	Usuario detalhar(Long id);

	Boolean usuarioExiste(Long id);

	Usuario atualizar(Long id, Usuario alteracao);

	boolean remover(Long id);

	Optional<Usuario> buscaPorEmail(String username);

}
