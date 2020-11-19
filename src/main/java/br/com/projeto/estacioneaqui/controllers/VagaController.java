package br.com.projeto.estacioneaqui.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.VagaService;

@RestController
@CrossOrigin
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaService vagaService;

	@PostMapping(path = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Vaga>> cadastrar(@RequestBody @Valid Vaga vaga,
			UriComponentsBuilder uriBuilder, BindingResult result) {

		Response<Vaga> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));

			return ResponseEntity.badRequest().body(response);

		} else {
			Vaga vagaCadastrado = vagaService.cadastrar(vaga);

			URI uri = uriBuilder.path("/vaga/{id}").buildAndExpand(vagaCadastrado.getId()).toUri();

			response.setData(vagaCadastrado);

			return ResponseEntity.created(uri).body(response);
		}

	}

	@GetMapping
	public ResponseEntity<List<Vaga>> listar() {
		List<Vaga> vagas = vagaService.listar();

		if (vagas.size() == 0) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok().body(vagas);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Vaga>> detalhar(@PathVariable("id") Long id) {

		Response<Vaga> response = new Response<>();

		if (vagaService.vagaExiste(id)) {

			Vaga vaga = vagaService.detalhar(id);
			response.setData(vaga);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Response<Vaga>> atualizar(@PathVariable Long id, @RequestBody Vaga alteracao) {

		Response<Vaga> response = new Response<>();

		if (vagaService.vagaExiste(id)) {

			Vaga vaga = vagaService.atualizar(id, alteracao);
			response.setData(vaga);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		if (vagaService.remover(id)) {
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
