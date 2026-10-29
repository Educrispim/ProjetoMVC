package com.biblioteca.biblioteca;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaginaInicialTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void raizDeveRenderizarAPaginaInicialSemErro() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("Bem-vindo")));
	}

	@Test
	void paginaDeLivrosDeveRenderizarSemErro() throws Exception {
		mockMvc.perform(get("/livros"))
				.andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("Bem-vindo")));
	}
}
