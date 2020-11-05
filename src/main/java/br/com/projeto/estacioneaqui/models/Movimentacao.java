package br.com.projeto.estacioneaqui.models;

import java.time.LocalDate;

import br.com.projeto.estacioneaqui.models.enums.TipoDeMovimentacao;

public class Movimentacao {

	private Long id;

	private TipoDeMovimentacao tipo;

	private String cpfCliente;

	private String placaCliente;

	private LocalDate entrada;

	private LocalDate saida;

	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDeMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeMovimentacao tipo) {
		this.tipo = tipo;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getPlacaCliente() {
		return placaCliente;
	}

	public void setPlacaCliente(String placaCliente) {
		this.placaCliente = placaCliente;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public LocalDate getSaida() {
		return saida;
	}

	public void setSaida(LocalDate saida) {
		this.saida = saida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
