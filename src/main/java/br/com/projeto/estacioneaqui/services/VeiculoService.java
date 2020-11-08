package br.com.projeto.estacioneaqui.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Veiculo;

@Service
public interface VeiculoService {

	List<Veiculo> listar();

	Veiculo cadastrar(Veiculo veiculo);

	Veiculo detalhar(Long id);

	Boolean veiculoExiste(Long id);

	Veiculo atualizar(Long id, Veiculo alteracao);

	boolean remover(Long id);

	Veiculo findById(Long id);

}
