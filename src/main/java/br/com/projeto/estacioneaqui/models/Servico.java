package br.com.projeto.estacioneaqui.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "servicos")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
//	
//	@NotBlank
//	@OneToMany(mappedBy = "servico")
//	private double precoPorHora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public double getPrecoPorHora() {
//		return precoPorHora;
//	}
//
//	public void setPrecoPorHora(double precoPorHora) {
//		this.precoPorHora = precoPorHora;
//	}

}
