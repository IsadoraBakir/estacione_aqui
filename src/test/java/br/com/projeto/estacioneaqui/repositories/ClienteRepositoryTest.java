package br.com.projeto.estacioneaqui.repositories;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projeto.estacioneaqui.models.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository repository;

	@Test
	public void teste() {
		Long id = (long) 1;
		Optional<Cliente> cliente = repository.findById(id);
		Assert.assertNotNull(cliente);
		Assert.assertEquals(id, cliente.get().getId());
	}

}
