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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.estacioneaqui.models.Movimentacao;
import br.com.projeto.estacioneaqui.models.form.CheckinForm;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService movimentacaoService;

	@PostMapping(path = "/checkin", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Movimentacao>> checkin(@RequestBody @Valid CheckinForm checkinForm,
			UriComponentsBuilder uriBuilder, BindingResult result) {

		Movimentacao movimentacaoCadastrada = movimentacaoService.converter(checkinForm);
		Response<Movimentacao> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);

		} else {
			URI uri = uriBuilder.path("/movimentacao/{id}").buildAndExpand(movimentacaoCadastrada.getId()).toUri();
			
			response.setData(movimentacaoCadastrada);
			
			return ResponseEntity.created(uri).body(response);
		}
	}

	@GetMapping
	public ResponseEntity<List<Movimentacao>> listar() {
		
		List<Movimentacao> movimentacoes = movimentacaoService.listar();
		
		if (movimentacoes.size() == 0) {
			return ResponseEntity.notFound().build();
			
		} else {
			return ResponseEntity.ok().body(movimentacoes);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Movimentacao>> detalhar(@PathVariable("id") Long id) {
		
		Response<Movimentacao> response = new Response<>();
		
		if(movimentacaoService.movimentacaoExiste(id)) {
			
			Movimentacao movimentacao = movimentacaoService.detalhar(id);
			response.setData(movimentacao);
			return ResponseEntity.ok().body(response);
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping("/checkout/{id}")
	public ResponseEntity<Response<Movimentacao>> checkout(@PathVariable("id") Long id) {
		
		Response<Movimentacao> response = new Response<>();
		
		if(movimentacaoService.movimentacaoExiste(id)) {
			
			Movimentacao movimentacao = movimentacaoService.detalhar(id);
			movimentacaoService.checkout(movimentacao);
			response.setData(movimentacao);
			return ResponseEntity.ok().body(response);
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		if (movimentacaoService.remover(id)) {
			return ResponseEntity.ok().build();
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
