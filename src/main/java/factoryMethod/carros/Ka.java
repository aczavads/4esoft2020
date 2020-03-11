package factoryMethod.carros;

public class Ka implements Carro {

	@Override
	public String getMarca() {
		return "Ford";
	}

	@Override
	public String getModelo() {
		return "Ka";
	}

	@Override
	public double getPotenciaEmCavalos() {
		return 80;
	}

	@Override
	public double getPortaMalasEmLitros() {
		return 260;
	}
	@Override
	public String toString() {
		return this.asString();
	}
	

}
