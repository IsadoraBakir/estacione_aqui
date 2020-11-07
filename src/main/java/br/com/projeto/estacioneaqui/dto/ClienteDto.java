//package br.com.projeto.estacioneaqui.dto;
//
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.Length;
//
//public class ClienteDto {
//
//	private String nome;
//
//	private String cpf;
//
//	private String telefone;
//	
////	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
////	private List<Veiculo> veiculo;
//	
////	@OneToMany(mappedBy = "cliente")
////	private List<Movimentacao> movimentacoes;
//
//	@NotNull(message = "Nome é obrigatório")
//	@Length(min = 11)
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	@NotNull(message = "Digite CPF somente com números")
//	@Length(min = 11)
//	public String getCpf() {
//		return cpf;
//	}
//
//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}
//
//	@NotNull(message = "Telefone deve conter DDD")
//	@Length(min = 10)
//	public String getTelefone() {
//		return telefone;
//	}
//
//	public void setTelefone(String telefone) {
//		this.telefone = telefone;
//	}
//	
////	public Cliente converter(ClienteService cursoRepository) {
////		Curso curso = cursoRepository.findByNome(nomeCurso);
////		return new Topico(titulo, mensagem, curso);
////	}
//	
//	
//}
