package br.com.projeto.estacioneaqui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.estacioneaqui.modelTeste.GenericEntity;
import br.com.projeto.estacioneaqui.repositoryTeste.GenericEntityRepository;

@SpringBootTest
class EstacioneAquiApplicationTests {

	@Autowired
    private GenericEntityRepository genericEntityRepository;

	@Test
	void contextLoads() {
		GenericEntity ge = new GenericEntity();
    	ge.setValue("Testando");
    	genericEntityRepository.save(ge);
	}

}
