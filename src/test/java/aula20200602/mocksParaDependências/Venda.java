package aula20200602.mocksParaDependências;

import java.math.BigDecimal;

public class Venda {
	private BigDecimal valor;
	private BigDecimal alíquotaIcms;
	private UnidadeFederativa ufDestino;
	
	public BigDecimal getValor() {
		return valor;
	}
	public BigDecimal getAlíquotaIcms() {
		return alíquotaIcms;
	}
	public UnidadeFederativa getUfDestino() {
		return ufDestino;
	}
	public Venda(BigDecimal valor, BigDecimal alíquotaIcms, UnidadeFederativa ufDestino) {
		super();
		this.valor = valor;
		this.alíquotaIcms = alíquotaIcms;
		this.ufDestino = ufDestino;
	}

}
