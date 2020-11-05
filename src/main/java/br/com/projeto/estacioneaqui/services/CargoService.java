package br.com.projeto.estacioneaqui.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.estacioneaqui.dto.CargoDto;
import br.com.projeto.estacioneaqui.models.Cargo;

@Service
public interface CargoService {
	
	CargoDto cadastrar(CargoDto cargo);
	
	List<Cargo> listarTodos();
}
