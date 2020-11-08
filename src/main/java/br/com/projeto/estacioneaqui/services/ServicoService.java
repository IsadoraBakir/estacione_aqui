package br.com.projeto.estacioneaqui.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Servico;

@Service
public interface ServicoService {

	List<Servico> listar();

	Servico detalhar(Long id);

	Servico atualizar(Long id, Servico alteracao);
	
	Boolean servicoExiste(Long id);

	boolean remover(Long id);

	Servico cadastrar(@Valid Servico servico);

	Servico findById(Long id);

}
