package aula20200602.mocksParaDependências;

import java.math.BigDecimal;

public interface GerenciadorDeParâmetros {
	
	//obterAlíquotaICMS(uf : UnidadeFederativa) : BigDecimal
	BigDecimal obterAlíquotaICMS(UnidadeFederativa uf);
	

}
