package mySpringBootApp;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import mySpringBootApp.livro.Livro;
import mySpringBootApp.livro.LivroController;
import mySpringBootApp.livro.LivroService;
import mySpringBootApp.livro.NotFoundException;


@WebMvcTest
@AutoConfigureMockMvc
class TestesComApiDeLivro {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private LivroController controller;
	
	@MockBean
	private LivroService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	

	@Test
	void testandoGetByIdComDadoInexistente() throws Exception {
		when(service.getById("2")).thenThrow(NotFoundException.class);

		mockMvc.perform(get("/api/livros/2")).andExpect(status().isNotFound());
	}
	
	@Test
	void testandoGetByIdComDadoExistente() throws Exception {
		Livro existente = new Livro("1", "Teste", 33);		
		when(service.getById("1")).thenReturn(existente);
		
		mockMvc.perform(get("/api/livros/1"))
		.andExpect(jsonPath("$.id").value("1"))
		.andExpect(jsonPath("$.titulo").value("Teste"))
		.andExpect(jsonPath("$.numeroDePaginas").value(33))
		.andExpect(status().isOk());
	}
	
	@Test
	void testandoGetAll() throws Exception {
		Livro a = new Livro("1", "A", 1);		
		Livro b = new Livro("2", "B", 2);		
		Livro c = new Livro("3", "C", 3);		
		when(service.getAll()).thenReturn(Arrays.asList(a,b,c));
		
		mockMvc.perform(get("/api/livros"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$.[0].id").value("1"))
		.andExpect(jsonPath("$.[1].id").value("2"))
		.andExpect(jsonPath("$.[2].id").value("3"))
		.andExpect(jsonPath("$.[0].titulo").value("A"))
		.andExpect(jsonPath("$.[1].titulo").value("B"))
		.andExpect(jsonPath("$.[2].titulo").value("C"))
		.andExpect(jsonPath("$.[0].numeroDePaginas").value("1"))
		.andExpect(jsonPath("$.[1].numeroDePaginas").value("2"))
		.andExpect(jsonPath("$.[2].numeroDePaginas").value("3"))
		.andExpect(status().isOk());
	}
	@Test
	void testandoPost() throws Exception {
		when(service.save(ArgumentMatchers.any(Livro.class))).thenReturn("99");
		
		Map<String, String> livro  = new HashMap<String, String>() {{
		    put("id", "99");
		    put("titulo", "Java Core 2020");
		    put("numeroDePaginas", "111");
		}};
		
		String livroComoJson = objectMapper.writeValueAsString(livro);
		
//		String livroComoJson = "{" 
//		+ "\"id\": \"99\"," 
//		+ "\"titulo\": \"Java Core 2020\"," 
//		+ "\"numeroDePaginas\": 111" 
//		+ "}";
		
		mockMvc.perform(post("/api/livros")
				.contentType(MediaType.APPLICATION_JSON)
				.content(livroComoJson))
		.andExpect(status().isCreated())
		.andExpect(content().string("99"));
	}
	

}







