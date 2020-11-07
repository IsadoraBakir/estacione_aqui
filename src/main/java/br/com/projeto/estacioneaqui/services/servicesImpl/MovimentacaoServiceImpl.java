package br.com.projeto.estacioneaqui.services.servicesImpl;

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
	
	private Object saida;

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
	public boolean remover(Long id) {

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
		
		
		
		return new Movimentacao(cliente, veiculo, vaga, servico);
	}
	
//	@Override
//	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
//	public Movimentacao checkout(Long id) {
//		Movimentacao movimentacao = detalhar(id);
//		Calendar entrada = movimentacao.getEntrada();
//		Calendar saida = Calendar.getInstance();
//		movimentacao.setSaida(saida);
//		return null;
//	}
	
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
