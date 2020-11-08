package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.estacioneaqui.models.Cliente;
import br.com.projeto.estacioneaqui.models.Movimentacao;
import br.com.projeto.estacioneaqui.models.Servico;
import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.models.Veiculo;
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
	@Transactional
	public Movimentacao cadastrar(Movimentacao movimentacao) {
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
	@Transactional
	public Movimentacao atualizar(Long id, Movimentacao alteracao) {

		Movimentacao movimentacao = detalhar(id);
		alteracao.setId(movimentacao.getId());
		return movimentacaoRepository.save(alteracao);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Movimentacao converter(CheckinForm form) {
		
		Cliente cliente = clienteService.findById(form.getClienteId());
		Veiculo veiculo = veiculoService.findById(form.getVeiculoId());
		Vaga vaga = vagaService.findById(form.getVagaId());
		Servico servico = servicoService.findById(form.getServicoId());
		
		Movimentacao movimentacao = new Movimentacao(cliente, veiculo, vaga, servico);

		List<Veiculo> veiculos = new ArrayList<>();
		veiculos.add(veiculo);
		cliente.setVeiculo(veiculos);
		
		return cadastrar(movimentacao);
	}
	
	@Override
	@Transactional
	public Movimentacao checkout(Movimentacao movimentacao) {
		
		movimentacao.getEntrada();
		movimentacao.setSaida(LocalDateTime.now());
		
		Double precoPorHora = movimentacao.getServico().getPrecoPorHora();
		
		Double valorFinal = calcularValorFinal(movimentacao.getEntrada(), movimentacao.getSaida(), precoPorHora);
		
		movimentacao.setValor(valorFinal);
		
//		Calendar entrada = movimentacao.getEntrada();
//		Calendar saida = Calendar.getInstance();
//		movimentacao.setSaida(saida);
		return movimentacaoRepository.save(movimentacao);
	}
	
	public Double calcularValorFinal(LocalDateTime entrada, LocalDateTime saida, Double precoPorHora) {
		Calendar duracao = Calendar.getInstance();
		Long entradaMillis = entrada.toEpochSecond(ZoneOffset.UTC);
		Long saidaMillis = saida.toEpochSecond(ZoneOffset.UTC);
		System.out.println(entrada);
		System.out.println(saida);
		
		duracao.setTimeInMillis(saidaMillis - entradaMillis);
		
		Double valorPorMinuto = precoPorHora / 60;
		Double tempoEmMinutos = (double) (duracao.getTimeInMillis() / 1000 / 60);
		Double valorFinal = tempoEmMinutos * valorPorMinuto; 
		System.out.println(valorFinal);
		return valorFinal;
	}
	
//	public calculaDuracao() {
//		Calendar entrada = Calendar.getInstance();
//		entrada.set(2020, 11, 6, 10, 30);
//		
//		Calendar saida = Calendar.getInstance();
//		saida.set(2020, 11, 6, 11, 00);
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
//		Calendar duracao = Calendar.getInstance();
//		duracao.setTimeInMillis(saida.getTimeInMillis() - entrada.getTimeInMillis());
//
////		
////
//	System.out.println("entrada: " + entrada.getTime());
//	System.out.println("saida: " + saida.getTime());
//	System.out.println("duracao: " + (duracao.getTimeInMillis() / 1000 / 60 ));
//	}

//	public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository) {
//		this.movimentacaoRepository = movimentacaoRepository;
//	}
//	
//	@Autowired
//	private FuncionarioRepository funcionarioRepository;
//
//	public CargoServiceImpl(CargoRepository cargoRepository) {
//		this.cargoRepository = cargoRepository;
//	}
//
//	@Override
//	public CargoDto cadastrar(CargoDto cargoDto) {
//		
//		Cargo cargo = new Cargo();
//		Funcionario funcionario = new Funcionario();
//		funcionario = funcionarioRepository.findByCpf(cargoDto.getCpf());
//		cargo.setDescricao(cargoDto.getDescricao());
//		cargo.setSalario(Double.parseDouble(cargoDto.getSalario()));
//		List<Funcionario> funcionarios = new ArrayList<>();
//		funcionarios.add(funcionario);
//		cargo.setFuncionarios(funcionarios);
//		cargo = cargoRepository.save(cargo);
//		cargoDto.setCpf(cargo.getFuncionarios().get(0).getCpf());
//		cargoDto.setId(cargo.getId().toString());
//		cargoDto.setDescricao(cargo.getDescricao());
//		cargoDto.setSalario(cargo.getSalario().toString());
//		
//		return cargoDto;
//	}
//
}
