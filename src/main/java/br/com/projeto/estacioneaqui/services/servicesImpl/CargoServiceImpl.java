package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.dto.CargoDto;
import br.com.projeto.estacioneaqui.models.Cargo;
import br.com.projeto.estacioneaqui.models.Funcionario;
import br.com.projeto.estacioneaqui.repositories.CargoRepository;
import br.com.projeto.estacioneaqui.repositories.FuncionarioRepository;
import br.com.projeto.estacioneaqui.services.CargoService;

@Service
public class CargoServiceImpl implements CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public CargoServiceImpl(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@Override
	public CargoDto cadastrar(CargoDto cargoDto) {
		
		Cargo cargo = new Cargo();
		Funcionario funcionario = new Funcionario();
		funcionario = funcionarioRepository.findByCpf(cargoDto.getCpf());
		cargo.setDescricao(cargoDto.getDescricao());
		cargo.setSalario(Double.parseDouble(cargoDto.getSalario()));
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(funcionario);
		cargo.setFuncionarios(funcionarios);
		cargo = cargoRepository.save(cargo);
		cargoDto.setCpf(cargo.getFuncionarios().get(0).getCpf());
		cargoDto.setId(cargo.getId().toString());
		cargoDto.setDescricao(cargo.getDescricao());
		cargoDto.setSalario(cargo.getSalario().toString());
		
		return cargoDto;
	}

	public List<Cargo> listarTodos() {
		return cargoRepository.findAll();
	}
}
