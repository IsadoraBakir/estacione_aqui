package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.estacioneaqui.models.Cliente;
import br.com.projeto.estacioneaqui.repositories.ClienteRepository;
import br.com.projeto.estacioneaqui.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Cliente detalhar(Long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Cliente atualizar(Long id, Cliente alteracao) {

		Cliente cliente = detalhar(id);
		alteracao.setId(cliente.getId());
		
		return clienteRepository.save(alteracao);
	}

	@Override
	@Transactional
	public boolean remover(Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).get();
	}

}
