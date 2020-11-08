package br.com.projeto.estacioneaqui.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Movimentacao;
import br.com.projeto.estacioneaqui.models.form.CheckinForm;

@Service
public interface MovimentacaoService {

	List<Movimentacao> listar();

	Movimentacao detalhar(Long id);
	
	Boolean movimentacaoExiste(Long id);

	Boolean remover(Long id);

	Movimentacao cadastrar(Movimentacao movimentacao);

	Movimentacao converter(CheckinForm form);

	Movimentacao checkout(Movimentacao movimentacao);

}
