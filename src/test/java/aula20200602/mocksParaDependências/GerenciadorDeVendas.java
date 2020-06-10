package aula20200602.mocksParaDependências;

import java.math.BigDecimal;

public class GerenciadorDeVendas {

	private GerenciadorDeParâmetros gerenciadorDeParâmetros;

	public GerenciadorDeVendas(GerenciadorDeParâmetros gerenciadorDeParâmetros) {
		this.gerenciadorDeParâmetros = gerenciadorDeParâmetros;
	}

	public Venda efetuarVenda(BigDecimal valor, UnidadeFederativa ufDestino) {
		BigDecimal alíquotaIcms = gerenciadorDeParâmetros.obterAlíquotaICMS(ufDestino);
		return new Venda(valor, alíquotaIcms, ufDestino);
	}

}
