package br.com.projeto.estacioneaqui;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.projeto.estacioneaqui.controllers.MovimentacaoController;

@SpringBootTest
@AutoConfigureMockMvc
class EstacioneAquiApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private MovimentacaoController movimentacaoController;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(movimentacaoController).build();
	}

	@org.junit.Test
	public void testaGETMovimentacao() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/movimentacao"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@org.junit.Test
	public void testaPOSTMovimentacao() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/movimentacao/checkin"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@org.junit.Test
	public void testaCheckin() throws Exception {		
		this.mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders.post("/movimentacao/checkin").contentType(MediaType.APPLICATION_JSON).content("{'clienteId': 1L,'veiculoId': 1L,'vagaId': 1L,'servicoId': 1L}")).andExpect(MockMvcResultMatchers.status().isOk()));
	}

	@Test
	void contextLoads() {
	}

}
