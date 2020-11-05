package br.com.projeto.estacioneaqui.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Cargo;

@Service
public interface CargoService {
	
	Cargo cadastrar(Cargo cargo);
	
	List<Cargo> listarTodos();
}
