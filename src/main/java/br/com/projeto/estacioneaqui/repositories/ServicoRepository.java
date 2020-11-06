package br.com.projeto.estacioneaqui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.estacioneaqui.models.Cliente;
import br.com.projeto.estacioneaqui.models.Movimentacao;
import br.com.projeto.estacioneaqui.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
