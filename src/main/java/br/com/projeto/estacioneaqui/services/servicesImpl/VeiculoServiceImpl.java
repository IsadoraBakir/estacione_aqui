package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.estacioneaqui.models.Veiculo;
import br.com.projeto.estacioneaqui.repositories.VeiculoRepository;
import br.com.projeto.estacioneaqui.services.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Veiculo> listar() {
		return veiculoRepository.findAll();
	}

	@Override
	@Transactional
	public Veiculo cadastrar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Veiculo detalhar(Long id) {
		return veiculoRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Boolean veiculoExiste(Long id) {

		Optional<Veiculo> veiculo = veiculoRepository.findById(id);

		if (veiculo.isPresent()) {
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional
	public Veiculo atualizar(Long id, Veiculo alteracao) {

		Veiculo veiculo = detalhar(id);
		alteracao.setId(veiculo.getId());

		return veiculoRepository.save(alteracao);
	}

	@Override
	@Transactional
	public boolean remover(Long id) {

		Optional<Veiculo> veiculo = veiculoRepository.findById(id);

		if (veiculo.isPresent()) {
			veiculoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Veiculo findById(Long id) {
		return veiculoRepository.findById(id).get();
	}
}
