package br.com.projeto.estacioneaqui.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "placa")
	private String placa;

	@Column(name = "cor", nullable = false)
	private String cor;
	
	@Lob
	@Column(name = "observacoes")
	private String observacoes;
//
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "veiculos_clientes", joinColumns = { @JoinColumn(name = "veiculo_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "cliente_id") })
//	private List<Cliente> clientes;
	
//	@OneToMany(mappedBy = "cliente")
//	private List<Movimentacao> movimentacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
