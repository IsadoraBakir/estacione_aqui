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

import br.com.projeto.estacioneaqui.models.Veiculo;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@PostMapping(path = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Veiculo>> cadastrar(@RequestBody @Valid Veiculo veiculo,
			UriComponentsBuilder uriBuilder, BindingResult result) {

		Response<Veiculo> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));

			return ResponseEntity.badRequest().body(response);
			
		} else {
			Veiculo veiculoCadastrado = veiculoService.cadastrar(veiculo);

			URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculoCadastrado.getId()).toUri();

			response.setData(veiculoCadastrado);

			return ResponseEntity.created(uri).body(response);
		}

	}

	@GetMapping
	public ResponseEntity<List<Veiculo>> listar() {
		List<Veiculo> veiculos = veiculoService.listar();

		if (veiculos.size() == 0) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok().body(veiculos);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Veiculo>> detalhar(@PathVariable("id") Long id) {

		Response<Veiculo> response = new Response<>();

		if (veiculoService.veiculoExiste(id)) {

			Veiculo veiculo = veiculoService.detalhar(id);
			response.setData(veiculo);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Response<Veiculo>> atualizar(@PathVariable Long id, @RequestBody Veiculo alteracao) {

		Response<Veiculo> response = new Response<>();

		if (veiculoService.veiculoExiste(id)) {

			Veiculo veiculo = veiculoService.atualizar(id, alteracao);
			response.setData(veiculo);
			return ResponseEntity.ok().body(response);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		if (veiculoService.remover(id)) {
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
