package br.com.projeto.estacioneaqui.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacoes")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "veiculo_id", nullable = false)
	private Veiculo veiculo;

	@ManyToOne
	@JoinColumn(name = "vaga_id", nullable = false)
	private Vaga vaga;
	
	@ManyToOne
	@JoinColumn(name = "servico_id", nullable = false)
	private Servico servico;

	@Column(name = "entrada", nullable = false)
	private Date entrada;

	@Column(name = "saida")
	private Date saida;

	@Column(name = "valor")
	private Double valor;
	
	public Movimentacao() {
		
	}

	public Movimentacao(Cliente cliente, Veiculo veiculo, Vaga vaga, Servico servico) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.vaga = vaga;
		this.servico = servico;
		this.entrada = Calendar.getInstance().getTime();
		this.valor = 0.0;
	}
	
//	public Movimentacao(Double valorFinal) {
//		this.saida = Calendar.getInstance().getTime();
//		this.valor = valorFinal;
//	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

//	@NotNull(message = "A vaga é uma informação obrigatória")
	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
