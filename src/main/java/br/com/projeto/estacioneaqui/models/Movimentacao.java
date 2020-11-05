package br.com.projeto.estacioneaqui.models;

import java.time.LocalDate;
import java.util.Calendar;

import br.com.projeto.estacioneaqui.models.enums.TipoDeMovimentacao;

public class Movimentacao {

	private Long id;

	private TipoDeMovimentacao tipo;

	private String cpfCliente;

	private String placaCliente;

	private Calendar entrada;

	private Calendar saida;

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

	public Calendar getEntrada() {
		return entrada;
	}

	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}

	public Calendar getSaida() {
		return saida;
	}

	public void setSaida(Calendar saida) {
		this.saida = saida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
