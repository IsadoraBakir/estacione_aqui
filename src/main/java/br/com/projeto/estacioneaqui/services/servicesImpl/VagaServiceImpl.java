package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.repositories.VagaRepository;
import br.com.projeto.estacioneaqui.services.VagaService;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaRepository vagaRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Vaga> listar() {
		return vagaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Vaga detalhar(Long id) {
		return vagaRepository.findById(id).get();
	}
	
	@Override
	@Transactional
	public Vaga cadastrar(Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Boolean vagaExiste(Long id) {

		Optional<Vaga> vaga = vagaRepository.findById(id);

		if (vaga.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean remover(Long id) {

		Optional<Vaga> vaga = vagaRepository.findById(id);

		if (vaga.isPresent()) {
			vagaRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	@Override
	@Transactional
	public Vaga atualizar(Long id, Vaga alteracao) {

		Vaga vaga = detalhar(id);
		alteracao.setId(vaga.getId());
		return vagaRepository.save(alteracao);
	}

	@Override
	public Vaga findById(Long id) {
		return vagaRepository.findById(id).get();
	}
}
