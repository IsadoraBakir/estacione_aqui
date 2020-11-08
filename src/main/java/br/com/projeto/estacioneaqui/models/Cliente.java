package br.com.projeto.estacioneaqui.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;

	@Column(name = "telefone", nullable = false)
	private String telefone;
//	
//	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
//	private List<Veiculo> veiculo;
//	
////	@OneToMany(mappedBy = "cliente")
////	private List<Movimentacao> movimentacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "Nome é obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "CPF é obrigatório e possui 11 digitos")
	@Length(min = 11)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotNull(message = "Telefone deve conter DDD")
	@Length(min = 10)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

//	public List<Veiculo> getVeiculo() {
//		return veiculo;
//	}
//
//	public void setVeiculo(List<Veiculo> veiculo) {
//		this.veiculo = veiculo;
//	}

}
