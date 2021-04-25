package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.estacioneaqui.models.Cliente;
import br.com.projeto.estacioneaqui.models.Movimentacao;
import br.com.projeto.estacioneaqui.models.Servico;
import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.models.Veiculo;
import br.com.projeto.estacioneaqui.models.enums.Status;
import br.com.projeto.estacioneaqui.models.form.CheckinForm;
import br.com.projeto.estacioneaqui.repositories.MovimentacaoRepository;
import br.com.projeto.estacioneaqui.services.ClienteService;
import br.com.projeto.estacioneaqui.services.MovimentacaoService;
import br.com.projeto.estacioneaqui.services.ServicoService;
import br.com.projeto.estacioneaqui.services.VagaService;
import br.com.projeto.estacioneaqui.services.VeiculoService;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private VagaService vagaService;

	@Autowired
	private ServicoService servicoService;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Movimentacao> listar() {
		return movimentacaoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Movimentacao detalhar(Long id) {
		return movimentacaoRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Boolean movimentacaoExiste(Long id) {

		Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);

		if (movimentacao.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public Movimentacao cadastrar(Movimentacao movimentacao) {
		movimentacao.getVaga().setStatus(Status.OCUPADA);
		
		return movimentacaoRepository.save(movimentacao);
	}

	@Override
	@Transactional
	public Boolean remover(Long id) {

		Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);

		if (movimentacao.isPresent()) {
			movimentacaoRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Movimentacao converter(CheckinForm form) {

		Cliente cliente = clienteService.findById(form.getClienteId());
		Veiculo veiculo = veiculoService.findById(form.getVeiculoId());
		Vaga vaga = vagaService.findById(form.getVagaId());
		Servico servico = servicoService.findById(form.getServicoId());

		Movimentacao movimentacao = new Movimentacao(cliente, veiculo, vaga, servico);

		return cadastrar(movimentacao);
	}

	@Override
	@Transactional
	public Movimentacao checkout(Movimentacao movimentacao) {
		
		movimentacao.setSaida(LocalDateTime.now());

		Double valorFinal = calcularValorFinal(movimentacao.getEntrada(), movimentacao.getSaida(), movimentacao.getServico().getPrecoPorHora());

		movimentacao.setValor(valorFinal);
		
		movimentacao.getVaga().setStatus(Status.LIVRE);

		return movimentacaoRepository.save(movimentacao);
	}

	public Double calcularValorFinal(LocalDateTime entrada, LocalDateTime saida, Double precoPorHora) {
		long duracao = entrada.until(saida, ChronoUnit.MINUTES);
		Double valorFinal = duracao * (precoPorHora / 60);
		return valorFinal;
	}
}
