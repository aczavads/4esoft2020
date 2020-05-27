package aula20200519.parcelamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parcelamento {

	public static List<Parcela> parcelar(BigDecimal valorParaParcelar, Integer númeroDeParcelas,
			Boolean diferençaNaPrimeiraParcela, BigDecimal valorMínimoDaParcela) {
		List<Parcela> parcelas = new ArrayList<>();
		
		BigDecimal valorDaParcela = valorParaParcelar.divide(new BigDecimal(númeroDeParcelas), 2, RoundingMode.HALF_DOWN);
		BigDecimal diferença = valorParaParcelar.subtract(valorDaParcela.multiply(new BigDecimal(númeroDeParcelas)));
		
		for (int i = 1; i <= númeroDeParcelas; i++) {
			if ((diferençaNaPrimeiraParcela && i == 1) || (!diferençaNaPrimeiraParcela && i == númeroDeParcelas)) {
				parcelas.add(new Parcela(i, valorDaParcela.add(diferença)));
			} else {
				parcelas.add(new Parcela(i, valorDaParcela));
			}
		}
		return parcelas;
	}
	/*
	return Arrays.asList(
			new Parcela(1, new BigDecimal("33.34")),
			new Parcela(1, new BigDecimal("33.33")),
			new Parcela(1, new BigDecimal("33.33")));
	*/

}
