package br.com.projeto.estacioneaqui.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto.estacioneaqui.models.Cliente;
import br.com.projeto.estacioneaqui.models.Usuario;
import br.com.projeto.estacioneaqui.models.Vaga;
import br.com.projeto.estacioneaqui.models.Veiculo;
import br.com.projeto.estacioneaqui.services.ClienteService;
import br.com.projeto.estacioneaqui.services.UsuarioService;
import br.com.projeto.estacioneaqui.services.VagaService;
import br.com.projeto.estacioneaqui.services.VeiculoService;

@Component
public class DummyData {

	@Autowired
	VagaService vagaService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	VeiculoService veiculoService;
	
	@Autowired
	UsuarioService usuarioService;
	
//	@PostConstruct
	public void cadastrarVagasAutomatico() {
		
		List<Vaga> vagas = new ArrayList<>();
		
		List<Cliente> clientes = new ArrayList<>();
		
		List<Usuario> usuarios = new ArrayList<>();
		
		List<Veiculo> veiculos = new ArrayList<>();
		
		Vaga vaga1 = new Vaga();
		vaga1.setLocalizacao("B10");
		
		Cliente cliente1 = new Cliente("Teste", "12312312323", "3199999999");
		Cliente cliente2 = new Cliente("Teste 2", "32132132111", "3122222222");
		Cliente cliente3 = new Cliente("Teste 3", "31231231222", "3133333333");
		
		Veiculo veiculo1 = new Veiculo("Prata", "Palio", "Teste", "AAA-1111");
		Veiculo veiculo2 = new Veiculo("Preto", "Fox", "Teste", "BBB-2222");
		
		Usuario usuario1 = new Usuario("Teste", "teste@email.com", "123123");
		Usuario usuario2 = new Usuario("Teste 2", "teste2@email.com", "123456");
		Usuario usuario3 = new Usuario("Teste 3", "teste3@email.com", "123321");
		
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
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		veiculos.add(veiculo1);
		veiculos.add(veiculo2);
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		for (Vaga vaga : vagas) {
			vagaService.cadastrar(vaga);
		}
		
		for (Cliente cliente : clientes) {
			clienteService.cadastrar(cliente);
		}
		
		for (Veiculo veiculo : veiculos) {
			veiculoService.cadastrar(veiculo);
		}
		
		for (Usuario usuario : usuarios) {
			usuarioService.cadastrar(usuario);
		}
		
	}
}
