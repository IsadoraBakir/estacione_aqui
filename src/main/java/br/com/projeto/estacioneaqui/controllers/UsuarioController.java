package br.com.projeto.estacioneaqui.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.estacioneaqui.models.Usuario;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(path = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Usuario>> cadastrar(@RequestBody @Valid Usuario usuario,
			UriComponentsBuilder uriBuilder, BindingResult result) {

		Response<Usuario> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));

			return ResponseEntity.badRequest().body(response);
			
		} else {
			Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);

			URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioCadastrado.getId()).toUri();

			response.setData(usuarioCadastrado);

			return ResponseEntity.created(uri).body(response);
		}

	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = usuarioService.listar();

		if (usuarios.size() == 0) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok().body(usuarios);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Usuario>> detalhar(@PathVariable("id") Long id) {

		Response<Usuario> response = new Response<>();

		if (usuarioService.usuarioExiste(id)) {

			Usuario usuario = usuarioService.detalhar(id);
			response.setData(usuario);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Response<Usuario>> atualizar(@PathVariable Long id, @RequestBody Usuario alteracao) {

		Response<Usuario> response = new Response<>();

		if (usuarioService.usuarioExiste(id)) {

			Usuario usuario = usuarioService.atualizar(id, alteracao);
			response.setData(usuario);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		if (usuarioService.remover(id)) {
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
