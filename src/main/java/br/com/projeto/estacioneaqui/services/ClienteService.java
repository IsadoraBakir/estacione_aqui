package br.com.projeto.estacioneaqui.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Cliente;

@Service
public interface ClienteService {

	List<Cliente> listar();

	Cliente cadastrar(Cliente cliente);

	Cliente detalhar(Long id);

	Boolean clienteExiste(Long id);

	Cliente atualizar(Long id, Cliente alteracao);

	boolean remover(Long id);

	Cliente findById(Long id);

}
