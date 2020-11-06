package br.com.projeto.estacioneaqui.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vagas")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "localizacao", nullable = false, unique = true)
	private String localizacao;
	
//	@OneToMany(mappedBy = "vaga")
//	private List<Movimentacao> movimentacoes;
	
//	@NotNull(message = "Vaga não existe")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "A localização da vaga é uma informação obrigatória")
	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

}
