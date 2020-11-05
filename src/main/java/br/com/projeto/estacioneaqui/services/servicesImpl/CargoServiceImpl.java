package br.com.projeto.estacioneaqui.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.models.Cargo;
import br.com.projeto.estacioneaqui.repositories.CargoRepository;
import br.com.projeto.estacioneaqui.services.CargoService;

@Service
public class CargoServiceImpl implements CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;

	public CargoServiceImpl(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@Override
	public Cargo cadastrar(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	public List<Cargo> listarTodos() {
		return cargoRepository.findAll();
	}
}
