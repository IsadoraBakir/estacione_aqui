package br.com.projeto.estacioneaqui.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Vaga;

@Service
public interface VagaService {
	
	Vaga cadastrar(Vaga vaga);
	
	List<Vaga> listar();
	
	Vaga detalhar(Long id);
	
	boolean remover(Long id);
	
	Vaga atualizar(Long id, Vaga alteracao);
//	CargoDto cadastrar(CargoDto cargo);
//	
}
