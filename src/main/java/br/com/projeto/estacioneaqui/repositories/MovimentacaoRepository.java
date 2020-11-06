package br.com.projeto.estacioneaqui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.estacioneaqui.models.Cliente;
import br.com.projeto.estacioneaqui.models.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{

}
