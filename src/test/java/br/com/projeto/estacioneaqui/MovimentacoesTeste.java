package br.com.projeto.estacioneaqui;

import org.junit.jupiter.api.Test;

import br.com.projeto.estacioneaqui.models.Movimentacao;

public class MovimentacoesTeste {

	@Test
	public void testeEntradaMovimentacao() {

		Movimentacao mov = new Movimentacao();

		System.out.println("Entrada: " + mov.getEntrada());
	}

}
