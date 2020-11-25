package br.com.projeto.estacioneaqui.models.form;

import javax.validation.constraints.NotNull;

public class CheckinForm {

	private Long clienteId;
	
	private Long veiculoId;
	
	private Long vagaId;
	
	private Long servicoId;

	@NotNull(message = "Cliente é uma informação obrigatória")
	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	@NotNull(message = "Veiculo é uma informação obrigatória")
	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	@NotNull(message = "Vaga é uma informação obrigatória")
	public Long getVagaId() {
		return vagaId;
	}

	public void setVagaId(Long vagaId) {
		this.vagaId = vagaId;
	}

	@NotNull(message = "Servico é uma informação obrigatória")
	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}
	
}
