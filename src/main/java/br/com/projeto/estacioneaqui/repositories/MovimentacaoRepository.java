package br.com.projeto.estacioneaqui.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.estacioneaqui.models.Movimentacao;
import br.com.projeto.estacioneaqui.models.Servico;
import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.models.Veiculo;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{

	List<Movimentacao> findByClienteId(Long id);
	
	List<Movimentacao> findByVeiculoId(Long id);
	
	List<Movimentacao> findByVagaId(Long id);
	
	List<Movimentacao> findByServicoId(Long id);
}
