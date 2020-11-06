package br.com.projeto.estacioneaqui.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaController {

	@Autowired
	VagaService vagaService;

	@GetMapping
	public ResponseEntity<List<Vaga>> listar() {
		List<Vaga> vagas = vagaService.listar();
		return ResponseEntity.ok().body(vagas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Vaga>> detalhar(@PathVariable("id") Long id) {
		Response<Vaga> response = new Response<>();
		Vaga vaga = vagaService.detalhar(id);
		response.setData(vaga);
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/atualizar/{id}")
	public Vaga atualizar(@PathVariable Long id, @RequestBody Vaga vagaAlterada) {
		return vagaService.atualizar(id, vagaAlterada);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		boolean vaga = vagaService.remover(id);
		if (vaga) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(path = "/cadastrar", consumes = "application/json")
	public ResponseEntity<Response<Vaga>> cadastrar(@RequestBody @Valid Vaga vaga, UriComponentsBuilder uriBuilder,
			BindingResult result) {

		Response<Vaga> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Vaga vagaCadastrada = vagaService.cadastrar(vaga);

		URI uri = uriBuilder.path("/vagas/{id}").buildAndExpand(vagaCadastrada.getId()).toUri();

		response.setData(vagaCadastrada);

		return ResponseEntity.created(uri).body(response);
	}

}
