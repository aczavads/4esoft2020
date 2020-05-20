package aula20200519.parcelamento;

import java.math.BigDecimal;

public class Parcela {
	private Integer número;
	private BigDecimal valor;
	
	
	public Integer getNúmero() {
		return número;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public Parcela(Integer número, BigDecimal valor) {
		super();
		this.número = número;
		this.valor = valor;
	}

}
