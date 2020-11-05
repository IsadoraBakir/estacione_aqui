package br.com.projeto.estacioneaqui.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.estacioneaqui.models.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
	List<Cargo> findByDescricao(String descricao);
}
