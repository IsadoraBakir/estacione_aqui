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
	@Transactional
	public Vaga cadastrar(Vaga vaga) {
		return vagaRepository.save(vaga);
	}
	
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
	public Vaga atualizar(Long id, Vaga vagaAlterada) {
		Vaga vaga = detalhar(id);
		vagaAlterada.setId(vaga.getId());
		return vagaRepository.save(vagaAlterada);
	}
	
//	public VagaServiceImpl(VagaRepository vagaRepository) {
//		this.vagaRepository = vagaRepository;
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
