//package br.com.projeto.estacioneaqui.utils;
//
//import java.util.HashSet;
//import java.util.Random;
//import java.util.Set;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import br.com.projeto.estacioneaqui.models.Vaga;
//import br.com.projeto.estacioneaqui.services.VagaService;
//
//@Component
//public class DummyData {
//
//	@Autowired
//	VagaService vagaService;
//	
//	@PostConstruct
//	public void cadastrarVagasAutomatico() {
//		
//		Random random = new Random();
//		Set<Integer> localizacoes = new HashSet<>(); 
//
//		for (int i = 0; i < 30; i++) {
//            localizacoes.add(random.nextInt(100));
//        }
//		
////		List<Vaga> vagasLista = new ArrayList<>();
//		Vaga vaga = new Vaga();
//		
//		for (Integer i : localizacoes) {
//			vaga.setLocalizacao("G" + i);
//			System.out.println(vaga.getLocalizacao());
//			vagaService.cadastrar(vaga);
//		}
//		
////		for (Vaga v : vagasLista) {
////			Vaga vagaNova = vagaService.cadastrar(v);
////			
////		}
//		
//	}
//}
