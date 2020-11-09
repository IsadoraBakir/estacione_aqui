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

import br.com.projeto.estacioneaqui.models.Servico;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	@PostMapping(path = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Servico>> cadastrar(@RequestBody @Valid Servico servico,
			UriComponentsBuilder uriBuilder, BindingResult result) {

		Response<Servico> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));

			return ResponseEntity.badRequest().body(response);

		} else {
			Servico servicoCadastrado = servicoService.cadastrar(servico);

			URI uri = uriBuilder.path("/servico/{id}").buildAndExpand(servicoCadastrado.getId()).toUri();

			response.setData(servicoCadastrado);

			return ResponseEntity.created(uri).body(response);
		}

	}

	@GetMapping
	public ResponseEntity<List<Servico>> listar() {
		List<Servico> servicos = servicoService.listar();

		if (servicos.size() == 0) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok().body(servicos);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Servico>> detalhar(@PathVariable("id") Long id) {

		Response<Servico> response = new Response<>();

		if (servicoService.servicoExiste(id)) {

			Servico servico = servicoService.detalhar(id);
			response.setData(servico);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Response<Servico>> atualizar(@PathVariable Long id, @RequestBody Servico alteracao) {

		Response<Servico> response = new Response<>();

		if (servicoService.servicoExiste(id)) {

			Servico servico = servicoService.atualizar(id, alteracao);
			response.setData(servico);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		if (servicoService.remover(id)) {
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
