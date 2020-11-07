package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.estacioneaqui.models.Servico;
import br.com.projeto.estacioneaqui.repositories.ServicoRepository;
import br.com.projeto.estacioneaqui.services.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Servico> listar() {
		return servicoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Servico detalhar(Long id) {
		return servicoRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Servico atualizar(Long id, Servico alteracao) {

		Servico servico = detalhar(id);
		alteracao.setId(servico.getId());

		if (alteracao.getDescricao() == null) {
			alteracao.setDescricao(servico.getDescricao());
			return servicoRepository.save(alteracao);

		} else if (alteracao.getPrecoPorHora() == 0) {
			alteracao.setPrecoPorHora(servico.getPrecoPorHora());
			return servicoRepository.save(alteracao);
		}

		return servicoRepository.save(alteracao);
	}

	@Override
	@Transactional
	public boolean remover(Long id) {

		Optional<Servico> servico = servicoRepository.findById(id);

		if (servico.isPresent()) {
			servicoRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	@Override
	@Transactional
	public Servico cadastrar(Servico servico) {
		return servicoRepository.save(servico);
	}

	@Override
	public Servico findById(Long id) {
		return servicoRepository.findById(id).get();
	}
}
