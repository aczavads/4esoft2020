package aula20200519.parcelamento;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestesComParcelamento {
	  //Parcelamento.parcelar(
	  //     valorParaParcelar : BigDecimal, 
	  //     quantidadeDeParcelas : int, 
	  //     diferençaNaPrimeiraParcela : boolean, 
	  //     valorMínimoDaParcela : BigDecimal) : List<Parcela>
/*	
	100.00
	3
	true
	10.00
	
	100.00 / 3 = 33.333333333333
	33.33
	33.33 * 3 = 99.99
	100.00 = 99.99 = 0.01
	
	Diferença na primeira parcela
	33.33 + 0.01 = 33.34
	 
	Parcelas resultantes 
	33.34
	33.33
	33.33
*/	
	@Test
	void testar_parcelamento_diferença_na_primeira_parcela() {
		BigDecimal valorParaParcelar = new BigDecimal("100.00");
		Integer númeroDeParcelas = 3;
		Boolean diferençaNaPrimeiraParcela = true;
		BigDecimal valorMínimoDaParcela = new BigDecimal("10.00");
		
		List<Parcela> parcelas = Parcelamento.parcelar(
				valorParaParcelar, númeroDeParcelas, diferençaNaPrimeiraParcela, valorMínimoDaParcela);
		
		assertEquals(3, parcelas.size());
		
		assertEquals(new BigDecimal("33.34"), parcelas.get(0).getValor());
		assertEquals(new BigDecimal("33.33"), parcelas.get(1).getValor());
		assertEquals(new BigDecimal("33.33"), parcelas.get(2).getValor());
	}

}
