package builder.base;

public class Bolo {
	private Cobertura cobertura;
	private SaborCobertura saborCobertura;
	private Massa massa;
	private SaborMassa saborMassa;
	private Recheio recheio;
	private SaborRecheio saborRecheio;
	private int quantidadeDeCamadas;
	private boolean frio;

	private Bolo() {
		
	}
	/*
	public Bolo(Cobertura cobertura, SaborCobertura saborCobertura, Massa massa, SaborMassa saborMassa, Recheio recheio,
			SaborRecheio saborRecheio, int quantidadeDeCamadas, boolean frio) {
				this.cobertura = cobertura;
				this.saborCobertura = saborCobertura;
				this.massa = massa;
				this.saborMassa = saborMassa;
				this.recheio = recheio;
				this.saborRecheio = saborRecheio;
				this.quantidadeDeCamadas = quantidadeDeCamadas;
				this.frio = frio;
	}

	public Bolo(Massa massa, SaborMassa saborMassa, boolean frio) {
		this.massa = massa;
		this.saborMassa = saborMassa;
		this.frio = frio;
	}
	*/
	
	public static class Builder {
		private Cobertura cobertura;
		private SaborCobertura saborCobertura;
		private Massa massa;
		private SaborMassa saborMassa;
		private Recheio recheio;
		private SaborRecheio saborRecheio;
		private int quantidadeDeCamadas;
		private boolean frio;
		
		public Builder frio() {
			this.frio = true;
			return this;
		}

		public Builder massa(Massa massa, SaborMassa saborMassa) {
			this.massa = massa;
			this.saborMassa = saborMassa;
			return this;
		}

		public Builder cobertura(Cobertura cobertura, SaborCobertura saborCobertura) {
			this.cobertura = cobertura;
			this.saborCobertura = saborCobertura;
			return this;
		}

		public Bolo builder() {
			Bolo novo = new Bolo();
			novo.cobertura = this.cobertura;
			novo.saborCobertura = this.saborCobertura;
			novo.frio = this.frio;
			novo.massa = this.massa;
			novo.saborMassa = this.saborMassa;
			novo.recheio = this.recheio;
			novo.saborRecheio = this.saborRecheio;
			return novo;
		}

	}


}


