//package br.com.projeto.estacioneaqui;
//
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import br.com.projeto.estacioneaqui.models.Vaga;
//import br.com.projeto.estacioneaqui.services.VagaService;
//
//public class VagasTeste {
//	
//	@Autowired
//	VagaService vagaService;
//	
//	@BeforeEach
//	public void inicializaService() {
//		this.vagaService = new VagaService() {
//			
//			@Override
//			public List<Vaga> listarTodas() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public Vaga cadastrar(Vaga vaga) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//	}
//
//	@Test
//	public void cadastraVagaRepetida(Vaga vaga) {
//		Vaga vagaSalva = new Vaga();
//		vagaSalva.setLocalizacao("G33");
//		vagaService.cadastrar(vaga);
//	}
//}
