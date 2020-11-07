package br.com.projeto.estacioneaqui.models.form;

public class CheckinForm {

	private Long clienteId;
	
	private Long veiculoId;
	
	private Long vagaId;
	
	private Long servicoId;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public Long getVagaId() {
		return vagaId;
	}

	public void setVagaId(Long vagaId) {
		this.vagaId = vagaId;
	}

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}
	
//	public Movimentacao converter(MovimentacaoService movimentacaoService) {
//		return movimentacaoService.converter();
//	}
}
