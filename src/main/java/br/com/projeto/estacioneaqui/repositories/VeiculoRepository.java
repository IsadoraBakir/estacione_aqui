package br.com.projeto.estacioneaqui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.models.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
