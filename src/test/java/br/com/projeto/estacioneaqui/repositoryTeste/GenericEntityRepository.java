package br.com.projeto.estacioneaqui.repositoryTeste;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.estacioneaqui.modelTeste.GenericEntity;

public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {
}
