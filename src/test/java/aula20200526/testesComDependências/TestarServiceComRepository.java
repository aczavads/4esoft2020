package aula20200526.testesComDependências;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class TestarServiceComRepository {
	
	@Test
	void testar_se_service_altera_nome_da_editora_com_mock() {
		ArgumentCaptor<Livro> livroCaptor = ArgumentCaptor.forClass(Livro.class);
		LivroRepository repo = Mockito.mock(LivroRepository.class);
		when(repo.findById("12")).thenReturn(new Livro("Sistemas Distribuídos", "Ática", 725));
		
		LivroService service = new LivroService(repo);		
		service.alterarEditora("12","Editora Salviati");		
		Livro recuperado = service.encontrarPeloId("12");
		
		
		verify(repo).save(livroCaptor.capture());
		assertEquals("Editora Salviati", livroCaptor.getValue().getEditora());
		verify(repo, times(0)).rollback();
		verify(repo, times(1)).commit();		
		assertEquals("Editora Salviati", recuperado.getEditora());
		
	}
	
	
	
	@Test
	void testar_se_service_altera_nome_da_editora_com_classe_anônima() {
		LivroRepository repo = new LivroRepository() {
			private Livro livro12 = new Livro("Sistemas Distribuídos", "Ática", 725);
			
			@Override
			public void save(Livro l) {
			}
			
			@Override
			public void rollback() {
			}
			
			@Override
			public Livro findById(String id) {
				if (id.equals("12")) {
					return livro12;
				}
				return null;
			}
			
			@Override
			public void commit() {
			}
		};
		
		LivroService service = new LivroService(repo);		
		service.alterarEditora("12","Editora Salviati");		
		Livro recuperado = service.encontrarPeloId("12");
		
		assertEquals("Editora Salviati", recuperado.getEditora());			
	}

}
