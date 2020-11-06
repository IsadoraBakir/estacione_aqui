package br.com.projeto.estacioneaqui.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.estacioneaqui.dto.CargoDto;
import br.com.projeto.estacioneaqui.models.Cargo;
import br.com.projeto.estacioneaqui.responses.Response;
import br.com.projeto.estacioneaqui.services.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	CargoService cargoService;

	@GetMapping
	public ResponseEntity<List<Cargo>> listar() {
		List<Cargo> cargos = cargoService.listarTodos();
		return ResponseEntity.ok().body(cargos);
	}
	
//	@GetMapping(value = "/buscaPorId")
//	public ResponseEntity<Cargo> listarPorId(@PathVariable )

	@PostMapping(value = "/cadastrar", consumes = "application/json")
	public ResponseEntity<Response<CargoDto>> cadastrar(@RequestBody @Valid CargoDto cargo, UriComponentsBuilder uriBuilder,
			BindingResult result) {

		Response<CargoDto> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().stream().map(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		CargoDto cargoCadastrado = cargoService.cadastrar(cargo);

		URI uri = uriBuilder.path("/cargos/{id}").buildAndExpand(cargoCadastrado.getId()).toUri();
		
		response.setData(cargoCadastrado);
		
		return ResponseEntity.created(uri).body(response);
	}
	
	
}
