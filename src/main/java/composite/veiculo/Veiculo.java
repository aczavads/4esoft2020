package composite.veiculo;

public class Veiculo {
	private UnidadeDePotencia unidadeDePotencia;

	public Veiculo(UnidadeDePotencia unidadeDePotencia) {
		this.unidadeDePotencia = unidadeDePotencia;
	}

	public void ligar() {
		System.out.println("Ligando...");
	}

	public void acelerar() {
		System.out.println("Vruuummmm com: " + unidadeDePotencia.fornecer() + "cv");
	}

}
