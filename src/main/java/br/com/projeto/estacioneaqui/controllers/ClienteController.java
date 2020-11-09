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

import br.com.projeto.estacioneaqui.models.Cliente;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping(path = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Cliente>> cadastrar(@RequestBody @Valid Cliente cliente,
			UriComponentsBuilder uriBuilder, BindingResult result) {

		Response<Cliente> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));

			return ResponseEntity.badRequest().body(response);
			
		} else {
			Cliente clienteCadastrado = clienteService.cadastrar(cliente);

			URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(clienteCadastrado.getId()).toUri();

			response.setData(clienteCadastrado);

			return ResponseEntity.created(uri).body(response);
		}

	}

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = clienteService.listar();

		if (clientes.size() == 0) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok().body(clientes);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Cliente>> detalhar(@PathVariable("id") Long id) {

		Response<Cliente> response = new Response<>();

		if (clienteService.clienteExiste(id)) {

			Cliente cliente = clienteService.detalhar(id);
			response.setData(cliente);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Response<Cliente>> atualizar(@PathVariable Long id, @RequestBody Cliente alteracao) {

		Response<Cliente> response = new Response<>();

		if (clienteService.clienteExiste(id)) {

			Cliente cliente = clienteService.atualizar(id, alteracao);
			response.setData(cliente);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		if (clienteService.remover(id)) {
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
