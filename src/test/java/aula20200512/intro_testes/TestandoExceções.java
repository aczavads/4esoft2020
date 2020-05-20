package aula20200512.intro_testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestandoExceções {
	
	@Test
	void nãoEsperandoExceçãoComAssertDoesNotThrow() {
		assertDoesNotThrow(() -> {
			gerarExceção(false);			
		});
	}
	
	
	@Test
	void esperandoUmaExceçãoAssertThrows() {
		assertThrows(TesteException.class, () -> {
			gerarExceção(true);			
		});
	}
	
	@Test
	void nãoEsperandoExceçãoComTryCatch() {
		try {
			gerarExceção(false);
		} catch (Throwable t) {
			fail("Não deveria ter gerado exceção!");
		}
	}

	@Test
	void esperandoUmaExceçãoComTryCatch() {
		try {
			gerarExceção(true);
			fail("Deveria ter gerado uma exceção!");
		} catch (TesteException e) {
			//Opa, se caiu aqui no catch está tudo certo, pois esperamos uma exceção!
		} catch (Throwable t) {
			fail("Deveria ter gerado uma TesteException!");
		}
	}
	
	void gerarExceção(boolean gerar) {
		if (gerar) {
			throw new TesteException();
			//throw new RuntimeException();
		}
	}
	
	class TesteException extends RuntimeException {
		
	}
	
	

}
