package br.com.projeto.estacioneaqui;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstacioneAquiApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

//	private MockMvc mockMvc;
//
//	@Autowired
//	private MovimentacaoController movimentacaoController;
//
//	@Before
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(movimentacaoController).build();
//	}
//
//	@org.junit.Test
//	public void testaGETMovimentacao() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/movimentacao"))
//				.andExpect(MockMvcResultMatchers.status().isOk());
//	}
//
//	@org.junit.Test
//	public void testaPOSTMovimentacao() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.post("/movimentacao/checkin"))
//				.andExpect(MockMvcResultMatchers.status().isOk());
//	}
//
//	@org.junit.Test
//	public void testaCheckin() throws Exception {		
//		this.mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders.post("/movimentacao/checkin").contentType(MediaType.APPLICATION_JSON).content("{'clienteId': 1L,'veiculoId': 1L,'vagaId': 1L,'servicoId': 1L}")).andExpect(MockMvcResultMatchers.status().isOk()));
//	}

}
