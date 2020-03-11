package factoryMethod.carros;

public interface Carro {
	
	String getMarca();
	String getModelo();
	double getPotenciaEmCavalos();
	double getPortaMalasEmLitros();

	public default String asString() {
		return this.getClass().getSimpleName() + " [getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getPotenciaEmCavalos()="
				+ getPotenciaEmCavalos() + ", getPortaMalasEmLitros()=" + getPortaMalasEmLitros() + "]";
	}

}
