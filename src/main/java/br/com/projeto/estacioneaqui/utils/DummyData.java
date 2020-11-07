package br.com.projeto.estacioneaqui.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.services.VagaService;

@Component
public class DummyData {

	@Autowired
	VagaService vagaService;
	
	//@PostConstruct
	public void cadastrarVagasAutomatico() {
		
		List<Vaga> vagas = new ArrayList<>();
		
		Vaga vaga1 = new Vaga();
		vaga1.setLocalizacao("B10");
		
		
		Vaga vaga2 = new Vaga();
		vaga2.setLocalizacao("B11");
		
		
		Vaga vaga3 = new Vaga();
		vaga3.setLocalizacao("B12");
		
		
		Vaga vaga4 = new Vaga();
		vaga4.setLocalizacao("B13");
		
		
		Vaga vaga5 = new Vaga();
		vaga5.setLocalizacao("B14");
		
		
		Vaga vaga6 = new Vaga();
		vaga6.setLocalizacao("B15");
		
		
		Vaga vaga7 = new Vaga();
		vaga7.setLocalizacao("B16");
		
		
		Vaga vaga8 = new Vaga();
		vaga8.setLocalizacao("B17");
		
		
		Vaga vaga9 = new Vaga();
		vaga9.setLocalizacao("B18");
		
		
		Vaga vaga10 = new Vaga();
		vaga10.setLocalizacao("B19");
		
		vagas.add(vaga1);
		vagas.add(vaga2);
		vagas.add(vaga3);
		vagas.add(vaga4);
		vagas.add(vaga5);
		vagas.add(vaga6);
		vagas.add(vaga7);
		vagas.add(vaga8);
		vagas.add(vaga9);
		vagas.add(vaga10);
		
		for (Vaga vaga : vagas) {
			vagaService.cadastrar(vaga);
		}
		
		
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
		
	}
}
