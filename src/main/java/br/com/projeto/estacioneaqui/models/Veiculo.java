package br.com.projeto.estacioneaqui.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "placa", nullable = false, unique = true)
	private String placa;
	
	@Column(name = "modelo")
	private String modelo;

	@Column(name = "cor")
	private String cor;
	
	@Lob
	@Column(name = "observacoes")
	private String observacoes;

	public Veiculo() {
	}

	public Veiculo(String cor, String modelo, String observacoes, String placa) {
		this.cor = cor;
		this.modelo = modelo;
		this.observacoes = observacoes;
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "Placa é obrigatório e possui 7 digitos")
	@Length(min = 7)
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

//	public List<Cliente> getClientes() {
//		return clientes;
//	}
//
//	public void setClientes(List<Cliente> clientes) {
//		this.clientes = clientes;
//	}	

}
